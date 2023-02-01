package eu.kaluzinski.credit_card.services;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

// Of course just for demo purposes. To be replaced with actual encryption like AES.
@Service
public class Base64EncodingService implements EncryptionService {

    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final Base64.Decoder decoder = Base64.getDecoder();

    @Override
    public String encrypt(String plainText) {
        return encoder.encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String decrypt(String encryptedText) {
        return new String(decoder.decode(encryptedText));
    }
}
