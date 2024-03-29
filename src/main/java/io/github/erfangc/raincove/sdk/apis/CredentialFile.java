package io.github.erfangc.raincove.sdk.apis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

class CredentialFile {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(CredentialFile.class);

    private CredentialFile() {
    }

    private static boolean credentialFileExists() {
        return getCredentialsFile().exists();
    }

    private static File getCredentialsFile() {
        return new File(System.getenv("HOME"), ".raincove/credentials.json");
    }

    static Credentials readCredentialFile() {
        if (credentialFileExists()) {
            final File credentialsFile = getCredentialsFile();
            try {
                final Credentials credentials = objectMapper.readValue(credentialsFile, Credentials.class);
                if (isExpired(credentials)) {
                    return null;
                } else {
                    return credentials;
                }
            } catch (IOException e) {
                logger.error("Error reading credentials from {}, message={}", credentialsFile.getAbsoluteFile(), e.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    static boolean isExpired(Credentials credentials) {
        final Base64 base64 = new Base64(true);
        String token = credentials.getAccessToken();
        try {
            final String jwtBody = token.split("\\.")[1];
            final JwtToken jwtToken = objectMapper.readValue(base64.decode(jwtBody), JwtToken.class);
            return Instant.ofEpochSecond(jwtToken.getExp()).isBefore(Instant.now());
        } catch (IOException e) {
            return true;
        }
    }

    static synchronized void saveCredentials(Credentials credentials) {
        final File credentialsFile = getCredentialsFile();
        final File absoluteFile = credentialsFile.getAbsoluteFile();
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(credentialsFile))) {
            objectMapper.writeValue(printWriter, credentials);
            absoluteFile.getParentFile().mkdirs();
            logger.info("Wrote credentials to {}", absoluteFile);
        } catch (Exception e) {
            logger.error("Failed to write credentials to {}, underlying error is {}", absoluteFile, e.getMessage());
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class JwtToken {
        private long exp;
        private long iat;
        private String azp;
        private String sub;
        private String iss;
        private String scope;

        public long getExp() {
            return exp;
        }

        public JwtToken setExp(long exp) {
            this.exp = exp;
            return this;
        }

        public long getIat() {
            return iat;
        }

        public JwtToken setIat(long iat) {
            this.iat = iat;
            return this;
        }

        public String getAzp() {
            return azp;
        }

        public JwtToken setAzp(String azp) {
            this.azp = azp;
            return this;
        }

        public String getSub() {
            return sub;
        }

        public JwtToken setSub(String sub) {
            this.sub = sub;
            return this;
        }

        public String getIss() {
            return iss;
        }

        public JwtToken setIss(String iss) {
            this.iss = iss;
            return this;
        }

        public String getScope() {
            return scope;
        }

        public JwtToken setScope(String scope) {
            this.scope = scope;
            return this;
        }
    }

}