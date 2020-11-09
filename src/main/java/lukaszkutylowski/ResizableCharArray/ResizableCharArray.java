package lukaszkutylowski.ResizableCharArray;

public class ResizableCharArray implements CharArray {

    private char[] body;

    public ResizableCharArray() {
        body = new char[0];
    }

    private char[] rewriteCharArray(char[] original, char[] copy) {
        if (original.length > 0) {
            for (int index = 0; index < original.length; index++) {
                copy[index] = original[index];
            }
        }
        return copy;
    }

    private char[] rewriteAndDeleteChar(char[] array, char[] temp, int indexOfDeleted) {
        int arrayIndex = 0;

        for (int index = 0; index < this.length() - 1; index++) {
            if (index == indexOfDeleted) {
                arrayIndex++;
                temp[index] = array[arrayIndex];
            } else {
                temp[index] = array[arrayIndex];
            }
            arrayIndex++;
        }
        return temp;
    }

    private int[] rewriteIntArray(int[] temporaryArray, int[] finalArray) {
        for (int index = 0; index <= finalArray.length - 1; index++) {
            finalArray[index] = temporaryArray[index];
        }
        return finalArray;
    }

    public int save(char letter) {
        body = rewriteCharArray(body, new char[this.length() + 1]);
        body[this.length() - 1] = letter;
        return this.length() - 1;
    }

    public char getByIndex(int index) {
        return body[index];
    }

    public char[] getAll() {
        return body;
    }

    public char delete(int index) {
        char deletedChar = getByIndex(index);
        body = rewriteAndDeleteChar(body, new char[this.length() - 1], index);
        return deletedChar;
    }

    public int length() {
        return body.length;
    }

    public int countChar(char letter) {
        int numberOfChars = 0;

        for (int index = 0; index < this.length(); index++) {
            if (this.getByIndex(index) == letter) {
                numberOfChars++;
            }
        }

        return numberOfChars;
    }

    public int findFirst(char letter) {
        for (int index = 0; index < this.length(); index++) {
            if (this.getByIndex(index) == letter) {
                return index;
            }
        }
        return -1;
    }

    public int findLast(char letter) {
        for (int index = this.length() - 1; index >= 0; index++) {
            if (this.getByIndex(index) == letter) {
                return index;
            }
        }
        return -1;
    }

    public int[] findAllIndex(char letter) {
        int numberOfIndexes = 0;
        int[] temporaryArray = new int[this.length()];

        for (int index = 0; index < length(); index++) {
            if (this.getByIndex(index) == letter) {
                temporaryArray[numberOfIndexes] = index;
                numberOfIndexes++;
            }
        }

        return rewriteIntArray(temporaryArray, new int[numberOfIndexes]);
    }

    public int[] deleteKindOfChar(char letter) {
        int[] indexes = this.findAllIndex(letter);

        for (int index = indexes.length - 1; index >= 0; index--) {
            this.delete(indexes[index]);
        }

        return indexes;
    }

    public String toStringBerlinClock() {
        String arrayAsString = "";

        for (int index = 0; index < this.length(); index++) {
            arrayAsString += this.getByIndex(index);
        }

        return arrayAsString;
    }

    @Override
    public String toString() {
        String arrayAsString = "[";

        for (int index = 0; index < this.length(); index++) {
            arrayAsString += this.getByIndex(index) + ",";
        }
        int lastIndex = arrayAsString.length() - 1;
        if (arrayAsString.length() > 1) {
            arrayAsString = arrayAsString.substring(0, lastIndex);
        }
        arrayAsString += "]";

        return arrayAsString;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj.getClass().equals(this.getClass())) {
            ResizableCharArray resizableCharArray = (ResizableCharArray) obj;
            if (resizableCharArray.length() == this.length()) {
                for (int index = 0; index < this.length() - 1; index++) {
                    if (this.getByIndex(index) != resizableCharArray.getByIndex(index)) {
                        return false;
                    }
                }
                return true;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (int index = 0; index < this.length(); index++) {
            sum += (int) body[index];
        }
        Double d = new Double(Math.log(sum) * Math.sqrt(sum));
        return d.intValue();
    }
}
