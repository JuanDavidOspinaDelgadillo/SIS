package SIS.example.Simple.Inventory.System.commons.constants.encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    private final TextEncryptor textEncryptor;

    @Autowired
    public EncryptionService(TextEncryptor textEncryptor){
        this.textEncryptor = textEncryptor;
    }

    public String encrypt(String charactersChain){
        return this.textEncryptor.encrypt(charactersChain);
    }

    public String decrypt(String encryptedCharactersChain){
        return this.textEncryptor.decrypt(encryptedCharactersChain);
    }
}