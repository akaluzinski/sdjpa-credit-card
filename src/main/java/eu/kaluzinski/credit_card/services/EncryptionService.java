package eu.kaluzinski.credit_card.services;

public interface EncryptionService {
    String encrypt(String plainText);
    String decrypt(String encryptedText);
}
