package lukaszkutylowski.ResizableCharArray;

public interface CharArray {

    int save(char letter);

    char getByIndex(int index);

    char[] getAll();

    char delete(int index);

    int length();

    int countChar(char letter);

    int findFirst(char letter);

    int findLast(char letter);

    int[] findAllIndex(char letter);

    int[] deleteKindOfChar(char letter);

    String toString();

    String toStringBerlinClock();
}
