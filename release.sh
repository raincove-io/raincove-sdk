#!/usr/bin/env bash
#
# Shell script to increase Java POM version, cut tags + handling bumping to the next snapshot version
#
function usage() {
    cat <<EOF
usage: $(basename $0) [-Mmpnr]
 -M major version
 -m minor version
 -p patch version
EOF
}

while getopts ":Mmp" Option
do
  case ${Option} in
    M ) major=true;;
    m ) minor=true;;
    p ) patch=true;;
    \?)
        usage
        exit 1
        ;;
  esac
done

shift $(($OPTIND - 1))

if [[ -z ${major} && -z ${minor} && -z ${patch} ]];
then
    usage
    exit 1
fi

groupId=io.github.erfangc
artifactId=raincove-sdk
repoUrl=https://repo1.maven.org/maven2

#
# find the latest version
#
groupIdUrl=$(echo io.github.erfangc | sed -e 's/\./\//g')
metadataUrl=${repoUrl}/${groupIdUrl}/${artifactId}/maven-metadata.xml
latestVersion=$(curl ${metadataUrl} 2>/dev/null | xmllint --xpath '/metadata/versioning/latest/text()' -)

# Build array from version string.

components=( ${latestVersion//./ } )

# If version string is missing or has the wrong number of members, show usage message.

if [[ ${#components[@]} -ne 3 ]]
then
  usage
  exit 1
fi

# Increment version numbers as requested.

if [[ ! -z ${major} ]]
then
  ((components[0]++))
  components[1]=0
  components[2]=0
fi

if [[ ! -z ${minor} ]]
then
  ((components[1]++))
  components[2]=0
fi

if [[ ! -z ${patch} ]]
then
  ((components[2]++))
fi

nextVersion="${components[0]}.${components[1]}.${components[2]}"

echo -e ----------------------------------------------------------------------------------------------------------------
echo -e Resolved artifact versions from ${metadataUrl}
echo -e groupId: ${groupId}
echo -e artifactId: ${artifactId}
echo -e latestVersion: ${latestVersion}
echo -e nextVersion: ${nextVersion}
echo -e ----------------------------------------------------------------------------------------------------------------

mvn -B versions:set -DnewVersion=${nextVersion} && mvn -B versions:commit
git tag v${nextVersion}
git checkout v${nextVersion}
echo Tag created: v${nextVersion}
echo Deploying to staging repository
mvn -B clean deploy

git checkout master
