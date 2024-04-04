import java.util.Arrays;

class Main
{
    private static void mergeArrays(int[] primary, int[] secondary, int primaryLength, int secondaryLength)
    {
        int index = primaryLength + secondaryLength + 1;

        while (primaryLength >= 0 && secondaryLength >= 0)
        {
            if (primary[primaryLength] > secondary[secondaryLength]) {
                primary[index--] = primary[primaryLength--];
            }
            else {
                primary[index--] = secondary[secondaryLength--];
            }
        }

        while (secondaryLength >= 0) {
            primary[index--] = secondary[secondaryLength--];
        }

        Arrays.fill(secondary, 0);
    }

    public static void rearrangeArrays(int[] primary, int[] secondary)
    {
        if (primary.length == 0) {
            return;
        }

        int index = 0;
        for (int value: primary)
        {
            if (value != 0) {
                primary[index++] = value;
            }
        }

        mergeArrays(primary, secondary, index - 1, secondary.length - 1);
    }

    public static void main (String[] args)
    {
        int[] primaryArray = { 0, 2, 0, 3, 0, 5, 6, 0, 0};
        int[] secondaryArray = { 1, 8, 9, 10, 15 };

        rearrangeArrays(primaryArray, secondaryArray);

        System.out.println(Arrays.toString(primaryArray));
    }
}
