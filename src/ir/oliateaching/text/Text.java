package ir.oliateaching.text;

public class Text {
    private char[] currentText;

    // Constructor from char array
    public Text(char[] inputCharacters) {
        if (inputCharacters == null) {
            this.currentText = new char[0];
        } else {
            this.currentText = new char[inputCharacters.length];
            for (int i = 0; i < inputCharacters.length; i++) {
                this.currentText[i] = inputCharacters[i];
            }
        }
    }

    // Constructor from String (without using String methods)
    public Text(String inputString) {
        if (inputString == null) {
            this.currentText = new char[0];
        } else {
            // Count characters manually
            int length = inputString.length();
            this.currentText = new char[length];
            for (int i = 0; i < length; i++) {
                this.currentText[i] = inputString.charAt(i);
            }
        }
    }

    // Default constructor
    public Text() {
        this.currentText = new char[0];
    }

    // Concatenates the given Text to the current Text
    public Text concat(Text newTextForConcatenating) {
        if (newTextForConcatenating == null || newTextForConcatenating.currentText.length == 0) {
            return this;
        }

        char[] result = new char[this.currentText.length + newTextForConcatenating.currentText.length];

        // Copy current value
        for (int i = 0; i < this.currentText.length; i++) {
            result[i] = this.currentText[i];
        }

        // Copy the text to be concatenated
        for (int i = 0; i < newTextForConcatenating.currentText.length; i++) {
            result[this.currentText.length + i] = newTextForConcatenating.currentText[i];
        }

        this.currentText = result;
        return this;
    }

    // Returns the index of the first occurrence of the specified character
    public int indexOf(char character) {
        for (int i = 0; i < currentText.length; i++) {
            if (currentText[i] == character) {
                return i;
            }
        }
        return -1;
    }

    // Replaces all occurrences of oldChars with newChars
    public Text replace(Text oldChars, Text newChars) {
        if (oldChars == null || oldChars.currentText.length == 0) {
            return this;
        }
        // current text: h e l l o w w o r d  i a  m  j  a  v  a  d  o  l  i  a
        //            i: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
        //
        //            j: 0 1 2 3
        //     oldChars: o l i a
        //
        //     newChars: s a v a r
        //
        //
        // Count occurrences manually
        int occurrenceCount = 0;
        for (int i = 0; i <= currentText.length - oldChars.currentText.length; i++) {
            boolean found = true;
            for (int j = 0; j < oldChars.currentText.length; j++) {
                if (currentText[i + j] != oldChars.currentText[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                occurrenceCount++;
            }
        }
        if (occurrenceCount == 0) {
            // Return original text
            return this;
        }
        // Calculate new length
        int newLength = currentText.length +
                occurrenceCount * (newChars.currentText.length - oldChars.currentText.length);

        char[] result = new char[newLength];
        int resultIndex = 0;
        int currentIndex = 0;

        for (int i = 0; i <= currentText.length - oldChars.currentText.length; i++) {
            boolean isOccurrence = true;
            for (int j = 0; j < oldChars.currentText.length; j++) {
                if (currentText[i + j] != oldChars.currentText[j]) {
                    isOccurrence = false;
                    break;
                }
            }
            if (isOccurrence) {
                // Copy characters before the occurrence
                for (int k = currentIndex; k < i; k++) {
                    result[resultIndex] = currentText[k];
                    resultIndex++;
                }
                // Copy newChars
                for (int k = 0; k < newChars.currentText.length; k++) {
                    result[resultIndex] = newChars.currentText[k];
                    resultIndex++;
                }
                currentIndex = i + oldChars.currentText.length;
                i = currentIndex - 1; // -1 because loop will increment
            }
        }
        // Copy remaining characters
        for (int i = currentIndex; i < currentText.length; i++) {
            result[resultIndex] = currentText[i];
            resultIndex++;
        }
        this.currentText = result;
        return this;
    }

    // Checks if this Text is equal to another Text
    public boolean equals(Text secoundText) {
        if (secoundText == null) {
            return false;
        }
        if (this.currentText.length != secoundText.currentText.length) {
            return false;
        }
        for (int i = 0; i < currentText.length; i++) {
            if (this.currentText[i] != secoundText.currentText[i]) {
                return false;
            }
        }
        return true;
    }

    // Utility method to print as string (without using String class)
    public void print() {
        for (int i = 0; i < currentText.length; i++) {
            System.out.print(currentText[i]);
        }
        System.out.println();
    }

    // Get the length of the Text
    public int length() {
        return currentText.length;
    }

    // Get character at specific index
    public char charAt(int index) {
        if (index < 0 || index >= currentText.length) {
            System.out.println("Index: " + index + ", Length: " + currentText.length);
            return ' ';
        }
        return currentText[index];
    }

    // Convert to char array (for external use)
    public char[] toCharArray() {
        char[] copy = new char[currentText.length];
        for (int i = 0; i < currentText.length; i++) {
            copy[i] = currentText[i];
        }
        return copy;
    }

    // Check if Text contains another Text
    public boolean contains(Text containsText) {
        if (containsText == null || containsText.currentText.length == 0) {
            return true;
        }

        if (containsText.currentText.length > currentText.length) {
            return false;
        }

        for (int i = 0; i <= currentText.length - containsText.currentText.length; i++) {
            boolean found = true;
            for (int j = 0; j < containsText.currentText.length; j++) {
                if (currentText[i + j] != containsText.currentText[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }
}