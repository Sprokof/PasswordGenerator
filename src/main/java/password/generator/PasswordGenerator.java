package password.generator;

import password.model.Password;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";
    private boolean useLower;
    private boolean useUpper;
    private boolean useDigits;
    private boolean usePunctuation;


    public PasswordGenerator() {}

    public PasswordGenerator useLower(boolean useLower) {
        this.useLower = useLower;
        return this;
    }

    public PasswordGenerator useUpper(boolean useUpper) {
        this.useUpper = useUpper;
        return this;
    }

    public PasswordGenerator useDigits(boolean useDigits) {
        this.useDigits = useDigits;
        return this;
    }

    public PasswordGenerator usePunctuation(boolean usePunctuation) {
        this.usePunctuation = usePunctuation;
        return this;
    }

    public Password generate(int length) {
        if (length <= 0) {
            return new Password("");
        }

        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        List<String> charCategories = new ArrayList<>(4);
        if (this.useLower) {
            charCategories.add(LOWER);
        }
        if (this.useUpper) {
            charCategories.add(UPPER);
        }
        if (this.useDigits) {
            charCategories.add(DIGITS);
        }
        if (this.usePunctuation) {
            charCategories.add(PUNCTUATION);
        }

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        return new Password(password.toString());
    }
}

