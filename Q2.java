class MaximumSumPathFinder {
    public static int findMaximumSum(int[] firstArray, int[] secondArray) {
        int sum = 0;
        int sumOfFirstArray = 0, sumOfSecondArray = 0;

        int lengthOfFirstArray = firstArray.length, lengthOfSecondArray = secondArray.length;

        int indexForFirstArray = 0, indexForSecondArray = 0;

        while (indexForFirstArray < lengthOfFirstArray && indexForSecondArray < lengthOfSecondArray) {
            while (indexForFirstArray < lengthOfFirstArray - 1 && firstArray[indexForFirstArray] == firstArray[indexForFirstArray + 1]) {
                sumOfFirstArray += firstArray[indexForFirstArray++];
            }

            while (indexForSecondArray < lengthOfSecondArray - 1 && secondArray[indexForSecondArray] == secondArray[indexForSecondArray + 1]) {
                sumOfSecondArray += secondArray[indexForSecondArray++];
            }

            if (secondArray[indexForSecondArray] < firstArray[indexForFirstArray]) {
                sumOfSecondArray += secondArray[indexForSecondArray];
                indexForSecondArray++;
            } else if (firstArray[indexForFirstArray] < secondArray[indexForSecondArray]) {
                sumOfFirstArray += firstArray[indexForFirstArray];
                indexForFirstArray++;
            } else {
                sum += Integer.max(sumOfFirstArray, sumOfSecondArray) + firstArray[indexForFirstArray];

                indexForFirstArray++;
                indexForSecondArray++;

                sumOfFirstArray = 0;
                sumOfSecondArray = 0;
            }
        }

        while (indexForFirstArray < lengthOfFirstArray) {
            sumOfFirstArray += firstArray[indexForFirstArray++];
        }

        while (indexForSecondArray < lengthOfSecondArray) {
            sumOfSecondArray += secondArray[indexForSecondArray++];
        }

        sum += Integer.max(sumOfFirstArray, sumOfSecondArray);
        return sum;
    }

    public static void main(String[] args) {
        int[] firstArray = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] secondArray = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};

        System.out.println("The maximum sum is " + findMaximumSum(firstArray, secondArray));
    }
}
