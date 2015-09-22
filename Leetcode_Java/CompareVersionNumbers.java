import java.util.*;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] versionOne = version1.split("\\.");
        // take care!!! "." can match any character in regular expression!!!
        String[] versionTwo = version2.split("\\.");
        if (versionOne.length > versionTwo.length) {
            return -1 * compareVersion(version2, version1);
            // version1 and version2 is swapped, so we need to multiply the result by -1
        }
        String[] versionOneExtend = new String[versionTwo.length];
        for (int i = 0; i < versionTwo.length; i++) {
            if (i < versionOne.length) {
                versionOneExtend[i] = versionOne[i];
            } else {
                versionOneExtend[i] = "0";
            }
        }
        int i = 0;
        while (i < versionTwo.length) {
            int one = Integer.parseInt(versionOneExtend[i]);
            int two = Integer.parseInt(versionTwo[i]);
            if (one > two) {
                return 1;
            } else if (one < two) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers test = new CompareVersionNumbers();
        System.out.println(test.compareVersion("1.4.3.0","1.4.3"));
        //System.out.println(Arrays.toString("1.4.3".split("\\.")));
    }
}