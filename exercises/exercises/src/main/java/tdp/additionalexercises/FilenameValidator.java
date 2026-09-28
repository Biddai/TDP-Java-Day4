package tdp.additionalexercises;

public class FilenameValidator {
    public boolean validate(String name) {
        if (name == null) {
            return false;
        }

        int dotIndex = name.indexOf('.');
        String baseName = name;
        String extension = "";
        if (dotIndex >= 0) {
            baseName = name.substring(0, dotIndex);
            extension = name.substring(dotIndex + 1);
        }

        if (baseName.length() < 1 || baseName.length() > 8) {
            return false;
        }
        if (extension.length() > 3) {
            return false;
        }
        return hasAllowedCharacters(baseName) && hasAllowedCharacters(extension);
    }

    private boolean hasAllowedCharacters(String text) {
        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);
            boolean isLetter = (character >= 'A' && character <= 'Z')
                    || (character >= 'a' && character <= 'z');
            boolean isDigit = character >= '0' && character <= '9';
            if (!isLetter && !isDigit && character != '-' && character != '_') {
                return false;
            }
        }
        return true;
    }
}
