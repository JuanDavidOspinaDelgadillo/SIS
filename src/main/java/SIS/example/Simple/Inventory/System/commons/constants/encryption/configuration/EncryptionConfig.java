package SIS.example.Simple.Inventory.System.commons.constants.encryption.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

@Configuration
public class EncryptionConfig {

    @Value("${secret.key}")
    private String secretKey;

    @Value("${secret.salt}")
    private String saltKey;

    @Bean
    public TextEncryptor textEncryptor(){
        return Encryptors.text(secretKey,saltKey);
    }
}