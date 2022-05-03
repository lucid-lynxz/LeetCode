import bean.ListNode;
import bean.TreeNode;

import java.util.*;


public class Solution {

    /**
     * 两数之和
     * https://leetcode-cn.com/problems/two-sum/submissions/
     *
     * @param nums   源数组
     * @param target 目标值
     * @return 返回数组中和为target的两元素下标
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int a = nums[i];
            for (int j = i + 1; j < len; j++) {
                int b = nums[j];
                if (a + b == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        int len = s.length();

        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        while (right < len) {
            char rightC = s.charAt(right);
            int rightCCount = charCountMap.getOrDefault(rightC, 0);
            rightCCount++;
            charCountMap.put(rightC, rightCCount);
            right++;

            if (rightCCount <= 1) {
                max = Math.max(max, right - left);
                continue;
            }

            while (rightCCount > 1) {
                char leftC = s.charAt(left);
                left++;
                if (leftC == rightC) {
                    rightCCount = 1;
                    charCountMap.put(rightC, rightCCount);
                } else {
                    charCountMap.remove(leftC);
                }
            }
        }

        return max;
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res;
        int m = nums1.length;
        int n = nums2.length;
        int pt1 = 0; // 数组1指针
        int pt2 = 0; // 数组2指针

        int size = m + n;
        int[] resArr = new int[size]; // 合并后的数组
        int index = 0; // 已填充的位数

        // 合并数组
        while (pt1 < m || pt2 < n) {
            int num1 = pt1 >= m ? Integer.MAX_VALUE : nums1[pt1];
            int num2 = pt2 >= n ? Integer.MAX_VALUE : nums2[pt2];
            if (num1 < num2) {
                resArr[index] = num1;
                pt1++;
            } else {
                resArr[index] = num2;
                pt2++;
            }
            index++;
        }

        // 计算新数组中位数
        int mid = size / 2; // 4 --> 2  5 --> 2
        int y = size % 2;
        if (y == 0) {
            res = (resArr[mid] + resArr[mid - 1]) / 2.0;
        } else {
            res = resArr[mid];
        }
        return res;
    }

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int maxSize = 1; // 最长回文数长度
        int maxLeft = 0; // 最长回文数的left下标值

        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isPalindrome(chars, i, j)) {
                    int size = j - i + 1;
                    if (size > maxSize) {
                        maxSize = size;
                        maxLeft = i;
                    }
                }
            }
        }
        return s.substring(maxLeft, maxLeft + maxSize);


//        int left = 0;
//        int right = 0;
//        int len = s.length();
//        int xor = 0;
//
//        int maxSize = 0; // 最长回文数长度
//        int maxLeft = 0; // 最长回文数的left下标值
//
//        char[] arr = new char[len];
//        int size = 0;
//        while (right < len) {
//            char c = s.charAt(right);
//            arr[right] = c;
//            xor ^= c;
//            right++;
//            size++;
//
//            int mid = size / 2;
//            int rest = size % 2;
//            // 可能是回文数
//            if ((rest == 0 && xor == 0)
//                    || (rest > 0 && xor == arr[mid])) {
//                boolean hit = isPalindrome(arr, left, right);
//                if (hit) { // 是回文数,则缓存起始下标
//                    if (size > maxSize) {
//                        maxSize = size;
//                        maxLeft = left;
//                    }
//                }
//            }
//        }
//        return null;
    }

    /**
     * 判断char数组的指定区间([left,right]闭区间)元素是否是回文数, 如: ['a','b','a','c'] ,则 left=0,right=2 元素 aba 是回文数
     */
    private boolean isPalindrome(char[] arr, int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return false;
        }

        int mid = size / 2;
        for (int i = 0; i < mid; i++) {
            if (arr[i + left] != arr[right - i]) {
                return false;
            }
        }
        return true;
    }


    public String longestPalindrome2(String s) {
        String maxString = null;
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = longPalindrome(s, i, i);
            String s2 = longPalindrome(s, i, i + 1);

            String tempS = s1.length() > s2.length() ? s1 : s2;
            if (maxString == null || tempS.length() > maxString.length()) {
                maxString = tempS;
            }
        }
        return maxString;

    }

    private String longPalindrome(String s, int midLeft, int midRight) {
        int left = midLeft;
        int right = midRight;

        int maxLeft = midLeft;
        int maxRight = midRight;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            maxLeft = left;
            maxRight = right;
            left--;
            right++;
        }

        return s.substring(maxLeft, maxRight + 1);
    }


    /**
     * 6. Z 字形变换
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
     * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * 示例 1：
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        char[][] arr = new char[numRows][len]; // 缓存所有字符,有冗余
        int rowIndex = 0; // 当前填充的行号
        int colIndex = 0; // 当前填充的列号
        boolean incRow = true; // 行号变化方向, true-增大 false-减小
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            arr[rowIndex][colIndex] = c;

            // 行号达到边界值(0或者最大值)后,要反方向变化
            if (incRow && rowIndex >= numRows - 1) {
                incRow = false;
                colIndex++; // 列号加1
            } else if (!incRow && rowIndex <= 0) {
                incRow = true; // 列号不变
            } else if (!incRow) {
                // z字形排列的特点是: 未填满的列的都是斜向右上方的
                // 即: 行号递减变坏时, 列号要加1
                colIndex++;
            }

            if (incRow) {
                rowIndex++;
            } else {
                rowIndex--;
            }

            if (rowIndex < 0) {
                rowIndex = 0;
            } else if (rowIndex > numRows - 1) {
                rowIndex = numRows - 1;
            }
        }
        colIndex = Math.min(len - 1, colIndex);

        // 打印数组,方便验证
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < colIndex; j++) {
//                if (arr[i][j] == Character.MIN_VALUE) {
//                    System.out.print("\t");
//                    continue;
//                }
//                System.out.print("\t" + arr[i][j]);
//            }
//            System.out.println();
//        }

        // 提取最后的结果,拼接成字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) { // 行号最大值固定为 numRows, 不包括
            for (int j = 0; j <= colIndex; j++) { // 列号最大值为 colIndex, 包括
                // 由于二维数组中有空白取余,要进行剔除
                if (arr[i][j] == Character.MIN_VALUE) {
                    continue;
                }
                sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }


    /**
     * 7. 整数反转
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     */
    public int reverse(int x) {
        int oriX = x;
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                System.out.println("reverse(" + oriX + ")1 -> 0");
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        System.out.println("reverse(" + oriX + ") -> " + rev);
        return rev;

//        // 最大值 2147483647, 提前判断溢出时允许的最值为 ?/10 ,然后再对余数进行判断
//        int tMax = Integer.MAX_VALUE / 10;
//        int tMin = Integer.MIN_VALUE / 10;
//
//        int oriX = x;
//        int result = 0;
//        while (x != 0) {
//            int temp = x % 10;
//            if (result == 0) {
//                result = temp;
//            } else {
//                // 由于可能会溢出, 且不允许使用long,允许需要提前判断
//                if (result > tMax || (result == tMax && temp > 7)) {
//                    System.out.println("reverse(" + oriX + ")1 -> 0");
//                    return 0;
//                } else if (result < tMin || (result == tMin && temp < -8)) {
//                    System.out.println("reverse(" + oriX + ")2 -> 0");
//                    return 0;
//                }
//                result = result * 10 + temp;
//            }
//            x /= 10;
//        }
//        System.out.println("reverse(" + oriX + ") -> " + result);
//        return result;


//        int oriX = x;
//        int count = (Math.abs(x) + "").length();
//
//        int[] result = new int[count];
//        for (int i = 0; i < count; i++) {
//            result[i] = x % 10;
//            x = x / 10;
//        }
//
//        x = result[0];
//        for (int i = 1; i < count; i++) {
//            if (i >= count - 2) {
//                if (x > (Integer.MAX_VALUE - Math.abs(result[i])) / 10.0) {
//                    System.out.println("reverse(" + oriX + ")1 -> 0");
//                    return 0;
//                } else if (x < (Integer.MIN_VALUE + Math.abs(result[i])) / 10.0) {
//                    System.out.println("reverse(" + oriX + ")2 -> 0");
//                    return 0;
//                }
//            }
//            // System.out.println("result[" + i + "]=" + result[i] + ",x=" + x);
//            x = x * 10 + result[i];
//        }
//        System.out.println("reverse(" + oriX + ") -> " + x);
//        return x;
    }

    /**
     * 8. 字符串转换整数 (atoi)
     * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     * 函数myAtoi(string s) 的算法如下：
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
     * 返回整数作为最终结果。
     * 注意：
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int myAtoi(String s) {
        int flag = 0; // 正负号, 0表示未出现过正负号,同时也标志默认正号
        boolean onlyNumCharEnable = false; // 是否之后只允许出现数字字符
        int result = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ' && !onlyNumCharEnable) {
                continue;
            }

            if ('-' == c && !onlyNumCharEnable) { // 若取过符号位, 又出现了正负号, 则返回0
                flag = -1;
                onlyNumCharEnable = true;
                continue;
            } else if ('+' == c && !onlyNumCharEnable) {
                flag = 1;
                onlyNumCharEnable = true;
                continue;
            } else if (c < '0' || c > '9') {
                break;
            }

            onlyNumCharEnable = true;
            int value = c - '0'; // 字符转数字
            // 边界范围判断
            if (flag >= 0 // 此处是 >=0, 因为默认0页表示正号, 表示未检测到符号位
                    && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && value > Integer.MAX_VALUE % 10))) {
                result = Integer.MAX_VALUE;
                break;
            } else if (flag == -1
                    && (-result < Integer.MIN_VALUE / 10 || (-result == Integer.MIN_VALUE / 10 && -value < Integer.MIN_VALUE % 10))) {
                result = Integer.MIN_VALUE;
                break;
            }
            result = result * 10 + value;
        }

        if (flag == -1 && result > 0) {
            result *= flag;
        }

        System.out.println("myAtoi(\"" + s + "\") -> " + result);
        return result;
    }


    /**
     * 9. 回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * 提示：
     * -2^31 <= x <= 2^31 - 1
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int result = 0;
        int oriX = x;
        boolean overFlow = false;
        while (x != 0) {
            int y = x % 10;
            x = x / 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && y > Integer.MAX_VALUE % 10)) {
                overFlow = true;
                break;
            }
            result = result * 10 + y;
        }

        boolean b = overFlow ? oriX / 10 == result : oriX == result;
        System.out.println("isPalindrome(" + oriX + ")=" + b + ",result=" + result + ",overFlow=" + overFlow);
        return b;
    }


    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
     * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
     * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
     * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
     * 给定一个罗马数字，将其转换成整数
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('Z', 0); // 自定义的0
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int len = s.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char n = 'Z';
            if (i < len - 1) {
                n = s.charAt(i + 1);
            }

            int cur = romanMap.get(c);
            int next = romanMap.get(n);

            result = result + cur;
            if (next > cur) {
                result = result + next - cur - cur;
                i++;
            }
        }

        System.out.println("romanToInt(\"" + s + "\")=" + result);
        return result;
    }


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串""。
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String longestCommonPrefix(String[] strs) {
        String pre = null; // 公共前缀
        for (String str : strs) {
            if (pre == null) {
                pre = str;
                continue;
            }

            // 比较最长前缀与当前元素的共同前缀值
            int lenPre = pre.length();
            int lenStr = str.length();
            int tLen = Math.min(lenPre, lenStr);
            if (tLen == 0) { // 长度为0,则无需比较,最长前缀为 ""
                pre = "";
                break;
            }

            // 逐个字符进行比较
            int resultLen = -1;
            for (int j = 0; j < tLen; j++) {
                char c1 = pre.charAt(j);
                char c2 = str.charAt(j);
                if (c1 == c2) {
                    resultLen = j;
                } else {
                    break;
                }
            }
            if (resultLen >= 0) {
                pre = str.substring(0, resultLen + 1);
            } else {
                pre = "";
            }
        }
        System.out.println("longestCommonPrefix ==> " + pre);
        return pre;
    }


    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) { // 奇数个括号, 直接返回false
            System.out.println("isValid(\"" + s + "\")=false");
            return false;
        }

        // (左括号,右括号)
        HashMap<Character, Character> mapLR = new HashMap<>();
        mapLR.put('(', ')');
        mapLR.put('[', ']');
        mapLR.put('{', '}');

        // (右括号,左括号)
        HashMap<Character, Character> mapRL = new HashMap<>();
        mapRL.put(')', '(');
        mapRL.put(']', '[');
        mapRL.put('}', '{');

        // 栈-存储左括号
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (mapLR.containsKey(c)) { // 当前是左括号,入栈
                deque.push(c);
            } else { // 当前为右括号, 则出栈左括号并比较
                if (deque.size() == 0) {
                    System.out.println("isValid(\"" + s + "\")=false");
                    return false;
                }

                Character pop = deque.pop();
                Character expectedLeft = mapRL.get(c);
                if (pop != expectedLeft) {
                    System.out.println("isValid(\"" + s + "\")=false");
                    return false;
                }
            }
        }

        boolean b = deque.size() == 0;
        System.out.println("isValid(\"" + s + "\")=" + b);
        return b;
    }


    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null; // 最终链表头
        ListNode current = null; // 当前拼接的元素
        while (list1 != null || list2 != null) {
            if (current == null) {
                current = new ListNode();
            } else {
                current.next = new ListNode();
                current = current.next;
            }

            if (head == null) {
                head = current;
            }

            int val1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int val2 = list2 == null ? Integer.MAX_VALUE : list2.val;

            ListNode next1 = list1 == null ? null : list1.next;
            ListNode next2 = list2 == null ? null : list2.next;

            if (val1 <= val2) {
                current.val = val1;
                list1 = next1;
            } else {
                current.val = val2;
                list2 = next2;
            }
        }

        // 打印结果, 方便验证
//        ListNode temp = head;
//        while (temp != null) {
//            System.out.print(temp.val + ",");
//            temp = temp.next;
//        }
//        System.out.println();
        return head;
    }


    /**
     * 27. 移除元素
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
     * 示例 1：
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int len = nums.length;
        for (int right = 0; right < len; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }

        System.out.print("size=" + left + " [");
        for (int i = 0; i < left; i++) {
            System.out.print(nums[i]);
            if (i < left - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        return left;
    }

    /**
     * 28. 实现 strStr()
     * 实现strStr()函数。
     * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     * 说明：
     * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
     * 示例 1：
     * 输入：haystack = "hello", needle = "ll"
     * 输出：2
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int strStr(String haystack, String needle) {
        // 暴力算法
        int lenH = haystack.length();
        int lenN = needle.length();
        for (int i = 0; i + lenN <= lenH; i++) {
            boolean hit = true;
            for (int j = 0; j < lenN; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    hit = false;
                    break;
                }
            }

            if (hit) {
                System.out.println("haystack=" + haystack + ",needle=" + needle + ",index=" + i);
                return i;
            }
        }
        System.out.println("haystack=" + haystack + ",needle=" + needle + ",index=-1");
        return -1;


        // 自己解决
//        int lenN = needle.length();
//        int lenH = haystack.length();
//        if (lenN == 0) {
//            System.out.println("haystack=" + haystack + ",needle=" + needle + ",index0=0");
//            return 0;
//        } else if (lenH < lenN) {
//            System.out.println("haystack=" + haystack + ",needle=" + needle + ",index1=-1");
//            return -1;
//        }
//
//        int left = 0; // hayStack指针
//        int right = 0; // needle指针
//
//        int index = -1; // 结果index值
//
//        while (left < lenH) {
//            char cH = haystack.charAt(left);
//            if (right >= lenN) {
//                break;
//            }
//
//            // 若haystack最后一位命中,但已无后续位,则直接退出
//            if (index + lenN > lenH) {
//                index = -1;
//                break;
//            }
//
//            char cN = needle.charAt(right);
//            if (cH == cN) {
//                if (index == -1) { // 匹配到 needle 首字符时, 赋值 index
//                    index = left;
//                }
//                left++;
//                right++;
//            } else if (index >= 0) { // 部分needle字符不匹配
//                left = index + 1; // 重置 left 为 index 的后一位
//                right = 0; // needle 指针置位为0, 从头开始匹配
//                index = -1;
//            } else {
//                left++;
//            }
//        }
//
//        System.out.println("haystack=" + haystack + ",needle=" + needle + ",index=" + index);
//        return index;
    }

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * 示例 1:
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     */
    public int searchInsert(Integer[] nums, int target) {
        // 问题转化为求解数组中第一个大于等于target的元素序号
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) / 2) + left; // 避免溢出, 不采用 (right + left)/2
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1; // 由于 nums[mid] 已经比较过, 此时right是在mid的基础上再减1
            } else {
                left = mid + 1; // left同理, 需要在mid的基础上再加1
            }
        }
        System.out.println(Arrays.toString(nums) + ",index=" + ans);
        return ans;


//        String arrStr = getArrStr(nums);
//        int len = nums.length;
//        if (nums[0] >= target) {
//            System.out.println(arrStr + ", target=" + target + ",index=0");
//            return 0;
//        } else if (nums[len - 1] < target) {
//            System.out.println(arrStr + ", target=" + target + ",index=" + len);
//            return len;
//        } else if (nums[len - 1] == target) {
//            System.out.println(arrStr + ", target=" + target + ",index=" + (len - 1));
//            return len - 1;
//        }
//
//        int right = len;
//        int left = 0;
//        int mid = len / 2;
//
//        // System.out.println("left=" + left + ",right=" + right + ",mid=" + mid + ",nums[mid]=" + nums[mid]);
//        while (left != right) {
//            if (nums[mid] > target) {
//                right = mid;
//            } else if (nums[mid] < target) {
//                left = mid;
//            } else {
//                System.out.println(arrStr + ", target=" + target + ",index=" + mid);
//                return mid;
//            }
//            mid = (left + right) / 2;
//            if (mid == left) {
//                mid = left + 1;
//                break;
//            } else if (mid == right) {
//                mid = right - 1;
//                break;
//            }
//            // System.out.println("left=" + left + ",right=" + right + ",mid=" + mid + ",nums[mid]=" + nums[mid]);
//        }
//
//        System.out.println(arrStr + ", target=" + target + ",index=" + mid);
//        return mid;
    }


    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组[4,-1,2,1] 的和最大，为6
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxSubArray(Integer[] nums) {
        // 动态规划
        // 子问题: 以 nums[i] 为结尾的最大子数组和是多少
        // 边界: i=0 --> dp[0]=nums[0]
        // i>0时  max(dp[i-1] + nums[i], nums[i])
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            int pre = dp[i - 1];
            if (pre > 0) {
                dp[i] = pre + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int max = dp[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(nums) + "  max=" + max);
        return max;
    }


    /**
     * 58. 最后一个单词的长度
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * 示例 1：
     * 输入：s = "Hello World"
     * 输出：5
     * 解释：最后一个单词是“World”，长度为5。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/length-of-last-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int end = -1;
        int index = len - 1;
        while (index >= 0) { // 搜索最后一个单词,因此从后往前遍历即可
            char c = s.charAt(index);
            if (c != ' ') {
                if (end < 0) {
                    end = index;
                }
            } else if (end >= 0) {
                break;
            }
            index--;
        }
        System.out.println("size=" + (end - index) + "  " + s);
        return end - index;
    }


    /**
     * 66. 加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例1：
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int index = len - 1;
        int carry = 1; // 进位值, 初始化值为1表示第一次运算加1操作
        while (index >= 0) {
            int cur = digits[index] + carry;
            digits[index] = cur % 10;
            carry = cur / 10;
            index--;
        }
        int[] result;
        if (carry == 0) { // 最高位无进位,则直接返回数组
            result = digits;
        } else { // 最高位有进位,则需要添加一个元素, 且第一个元素值为1, 其他元素为0
            result = new int[len + 1];
            result[0] = 1;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 67. 二进制求和
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字1和0。
     * 示例1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-binary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int maxLen = Math.max(lena, lenb);

        char[] ans = new char[maxLen + 1]; // 可能有进位,额外增加1位备用
        int carry = 0;

        int ptra = lena - 1;
        int ptrb = lenb - 1;
        int ptrAns = maxLen;

        while (ptrAns >= 0) {  // 从字符串最后一位向前遍历, ptrAns>=0 确保了 ptra ptrb 均已完整遍历过
            char ca = ptra >= 0 ? a.charAt(ptra) : '0';
            char cb = ptrb >= 0 ? b.charAt(ptrb) : '0';
            int ia = ca == '0' ? 0 : 1;
            int ib = cb == '0' ? 0 : 1;

            int cur = ia + ib + carry;
            carry = cur / 2;
            ans[ptrAns] = (cur % 2) == 0 ? '0' : '1';

            ptra--;
            ptrb--;
            ptrAns--;
        }

        String s;
        if (ans[0] == '0') { // 删除前导0
            s = new String(ans, 1, maxLen);
        } else {
            s = new String(ans);
        }
        System.out.println(s);
        return s;
    }

    /**
     * 69. x 的平方根
     * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            System.out.println("x=" + x + ",left=" + x);
            return x;
        }

        int left = 1;
        int right = x;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) { // 避免溢出, 使用除法, 但除数是mid, 也要考虑0的情况
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("x=" + x + ",ans=" + ans);
        return ans;
    }

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int climbStairs(int n) {
        // n 1 2 3 4 5 6  7  8
        //   1 2 3 5 8 13 21 34
        int ans = fab(n);
        System.out.println("n=" + n + ",ans=" + ans);
        return ans;


        // 排列组合解法
//        int max2 = n / 2; // 最多几个2
//        int size = 1; // 所有全部为1
//        for (int i = 1; i <= max2; i++) { // 从包含1个2阶台阶开始计算
//            int step = i + (n - i * 2); // 步数
//
//            // 排列组合  Cnm = n!/(m!*(n-m)!)  可能会溢出,long都不够用, 只能确保n足够小时才可用
//            long factorial = factorial(step - i);
//            long factorial1 = factorial(i);
//             System.out.println("step=" + step + ",i=" + i + ",factorial=" + factorial);
//            long count = step == 1 ? 1 : factorial(step) / (factorial1 * factorial);
//            size += count;
//        }
//        System.out.println("n=" + n + ",size=" + size);
//        return size;
    }

    private final Map<Integer, Integer> memoFab = new HashMap<>();

    public int fab(int n) {
        Integer integer = memoFab.get(n);
        if (integer != null) {
            return integer;
        }

        if (n == 1) {
            memoFab.put(1, 1);
            return 1;
        } else if (n == 2) {
            memoFab.put(2, 2);
            return 2;
        }
        int i = fab(n - 1) + fab(n - 2);
        memoFab.put(n, i);
        return i;
    }

    // 阶乘
    public static long factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }


    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
     * 示例 1：
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            int val = cur.val;
            ListNode nextNode = cur.next;
            int nextVal = nextNode == null ? val : nextNode.val;
            while (nextNode != null && nextVal == val) {
                nextNode = nextNode.next;
                cur.next = nextNode;
                nextVal = nextNode == null ? val : nextNode.val;
            }
            cur = nextNode;
        }

        // 打印结果, 方便验证
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();

        return head;
    }

    /**
     * 88. 合并两个有序数组
     * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     * 示例 1：
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        int ptrAns = len - 1;
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        while (ptr1 >= 0 || ptr2 >= 0) {
            int val1 = ptr1 >= 0 ? nums1[ptr1] : Integer.MIN_VALUE;
            int val2 = ptr2 >= 0 ? nums2[ptr2] : Integer.MIN_VALUE;

            if (val1 <= val2) {
                nums1[ptrAns] = val2;
                ptr2--;
            } else {
                nums1[ptrAns] = val1;
                ptr1--;
            }
            ptrAns--;
        }

        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 前序遍历: 根->左->右
        // 中序遍历: 左->根->右
        // 后序遍历: 左->右->根
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list; // 由于题目要求输入null节点,返回空列表, 因此此处不能返回null
        }

        // 递归遍历左子树
        list.addAll(inorderTraversal(root.left));

        // 输出根节点
        list.add(root.val);

        // 遍历右子树
        list.addAll(inorderTraversal(root.right));
        return list;
    }


    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
     * 解法2: 迭代解法
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // 中序遍历: 左子树 -> 中间节点 -> 右子树
        // 栈stack: 后进先出
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }

        return list;
    }

    /**
     * 144. 二叉树的前序遍历
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list; // 由于题目要求输入null节点,返回空列表, 因此此处不能返回null
        }

        // 输出根节点
        list.add(root.val);

        // 递归遍历左子树
        list.addAll(preorderTraversal(root.left));

        // 遍历右子树
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    /**
     * 144. 二叉树的前序遍历
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list; // 由于题目要求输入null节点,返回空列表, 因此此处不能返回null
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 优先输出根节点, 然后递归输出左子树
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            root = node.right;
        }

        return list;
    }

    /**
     * 145. 二叉树的后序遍历
     * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
     * <p>
     * 递归解法参照中序/前序遍历, 本题尝试下迭代解法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list; // 由于题目要求输入null节点,返回空列表, 因此此处不能返回null
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;   // 递归输出左子树
            }

            TreeNode node = stack.pop(); // 左子树遍历完成

            // 在输出根节点前, 需要判断是否有右子树, 若有, 则先将根节点入栈, 然后右节点入栈, 最终会先输出右子树
            // 但判断条件若仅 if (node.right == null) {} 则在出栈时会死循环, 因此需记录之前已输出过的节点, 因此引入变量 pre
            if (node.right == null || node.right == pre) {
                list.add(node.val);
                pre = node;
            } else {
                stack.push(node);
                root = node.right;
            }
        }

        return list;
    }


    /**
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * 示例 1：
     * 输入：p = [1,2,3], q = [1,2,3]
     * 输出：true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/same-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明:叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 3
     * /  \
     * 9   20
     * /  \
     * 15   7
     * 返回它的最大深度3
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        int depthL = maxDepth(root.left, depth + 1);
        int depthR = maxDepth(root.right, depth + 1);
        return Math.max(depthL, depthR);
    }

    /**
     * 101. 对称二叉树
     * https://leetcode-cn.com/problems/symmetric-tree/
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * <p>
     * 题解:
     * 1. rootNode 为空,则自然是对称的
     * 2. rootNode 非空,则要求其左子树与右子树对称
     * -        a. 左右子树根节点值一致
     * -        b. 左子树的左节点与右子树的右节点一致
     * -        c. 左子树的右节点与右子树的左节点一致
     * 以上,即可得出递归解法
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 102. 二叉树的层序遍历
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderImpl(root, result, 0);
        return result;
    }

    private void levelOrderImpl(TreeNode root, List<List<Integer>> result, int index) {
        if (root == null) {
            return;
        }

        int size = result.size();
        List<Integer> list;
        if (index >= size) {
            list = new ArrayList<>();
            result.add(list);
        } else {
            list = result.get(index);
        }
        list.add(root.val);

        // 获取下一层数据
        levelOrderImpl(root.left, result, index + 1);
        levelOrderImpl(root.right, result, index + 1);
    }

    /**
     * 107. 二叉树的层序遍历 II
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // BFS 广度优先算法, 与102题类似,顺序相反而已, 因此依然是list存储,每次往list开头插入即可
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }


    /**
     * 108. 将有序数组转换为二叉搜索树
     * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * <p>
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     * 示例 1：
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案
     * 提示：
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 按 严格递增 顺序排列
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortedArrayToBSTHelper(nums, 0, nums.length - 1);
//        // 中序遍历,打印方便查看
//        List<Integer> integers = inorderTraversal(root);
//        String s = ListUtil.toString(integers);
//        System.out.println(s);
        return root;
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        // 终止条件,考虑只有一个元素的情况, 则初始left==right, 需要下一轮递归才能终止
        if (left > right) {
            return null;
        }
        // 提取数组中间元素作为root节点
        int mid = (left + right) / 2; // 偶数-中间靠左  奇数-中间
        TreeNode node = new TreeNode(nums[mid]);// root节点
        node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        return node;
    }

    /**
     * 110. 平衡二叉树
     * https://leetcode-cn.com/problems/balanced-binary-tree/
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
     * <p>
     * 解法1: 自顶向下递归,依次计算所有节点的树高,比较左右子树高度差是否小于2
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 递归终止条件:
        // 左右子树高度差大于等于2 -> 非平衡子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        int dL = height(left); // 左子树高度
        int dR = height(right); // 右子树高度
        return Math.abs(dL - dR) < 2 && isBalanced(left) && isBalanced(right);
    }

    /**
     * 求树的高度
     */
    private int height(TreeNode root) {
        if (root == null) { // 叶节点, 高度为0
            return 0;
        }
        // 左右子树最大高度再加1就是当前节点为root节点的树高
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * 110. 平衡二叉树
     * https://leetcode-cn.com/problems/balanced-binary-tree/
     * 解法2: 自底向上
     */
    public boolean isBalanced2(TreeNode root) {
        isBalance2Helper(root);
        return isBalanced2Flag;
    }

    boolean isBalanced2Flag = true;

    public int isBalance2Helper(TreeNode root) {
        if (root == null) { // 叶节点高度返回0
            return 0;
        }

        if (!isBalanced2Flag) { // 若已发现非平衡树,则直接返回, 结果数字不重要
            return 0;
        }
        int left = isBalance2Helper(root.left) + 1; // 左子树高度
        int right = isBalance2Helper(root.right) + 1; // 右子树高度
        int abs = Math.abs(left - right);
        if (abs >= 2) { // 左右子树高度差大于1,则此树为非平衡树
            isBalanced2Flag = false;
        }
        return Math.max(left, right); // 返回树高
    }

    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minDepth(TreeNode root) {
        if (root == null) { // 空树, 直接返回0
            return 0;
        }
        return minDepth(root, 1);
    }

    /**
     * 递归直到叶子节点
     * 叶子节点: node!=null && node.left==null && node.right==null
     */
    private int minDepth(TreeNode node, int depth) {
        // 若node节点不存在,则其并非叶子节点,由于需要获取最小节点树,因此直接返回最大值
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        // 当前已是叶子节点,则返回深度
        if (node.left == null && node.right == null) {
            return depth;
        }

        // 当前非叶子节点, 则递归子节点, 直到叶子节点
        return Math.min(minDepth(node.left, depth + 1), minDepth(node.right, depth + 1));
    }

    /**
     * 112. 路径总和
     * https://leetcode-cn.com/problems/path-sum/
     * <p>
     * [1,2] 求和1 -> false
     * [-2,null,-3]  -5 -> true
     * [1,-2,-3,1,3,-2,null,-1] -1 -> true
     */
    public boolean hasPathSum(TreeNode root, int targetSum, boolean expected) {
        boolean b = hasPathSum(root, targetSum, 0);
        System.out.println("hasPathSum:" + inorderTraversal(root) + ",expected=" + expected + ",result=" + b);
        return b;
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.val;
        if (root.left == null && root.right == null) { // 叶子节点
            return sum == targetSum;
        }

        return hasPathSum(root.left, targetSum, sum) || hasPathSum(root.right, targetSum, sum);
    }

    /**
     * 113. 路径总和 II
     * https://leetcode-cn.com/problems/path-sum-ii/
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result113.clear();
        path113.clear();
        pathSumDfs(root, targetSum);
        System.out.println("pathSum: " + result113);
        return result113;
    }

    // linkedList双向链表,删除结尾时比较方便
    List<List<Integer>> result113 = new LinkedList<>(); // 存储结果
    LinkedList<Integer> path113 = new LinkedList<>(); // 存储当前计算路径

    private void pathSumDfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path113.offerLast(root.val); // 添加当前元素
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) { // 叶子节点且满足求和要求
            result113.add(new LinkedList<>(path113)); // 创建一个新链表,加到结果list中
        }
        pathSumDfs(root.left, targetSum);
        pathSumDfs(root.right, targetSum);
        path113.pollLast();
    }

    /**
     * 118. 杨辉三角
     * https://leetcode-cn.com/problems/pascals-triangle/
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // 行首元素

            if (i >= 2) {
                List<Integer> preRow = res.get(res.size() - 1);
                for (int j = 1; j < i; j++) {
                    row.add(preRow.get(j - 1) + preRow.get(j));
                }
            }

            if (i >= 1) {
                row.add(1); // 行尾元素
            }
            res.add(row);
        }
        // System.out.println("numRows=" + numRows + ": " + res);
        return res;
    }

    /**
     * 119. 杨辉三角 II
     * https://leetcode-cn.com/problems/pascals-triangle-ii/
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = generate(rowIndex + 1);
        List<Integer> ans = res.get(res.size() - 1);
        System.out.println("rowIndex=" + rowIndex + ",ans:" + ans);
        return ans;
    }

    /**
     * 121. 买卖股票的最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        System.out.println("maxProfit=" + maxProfit);
        return maxProfit;
    }

    /**
     * 125. 验证回文串
     * https://leetcode-cn.com/problems/valid-palindrome/
     * <p>
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     * 说明：本题中，我们将空字符串定义为有效的回文串
     */
    public boolean isPalindrome(String s) {
        if (s.trim().length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;

        while (r > l) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);

            while (!Character.isLetterOrDigit(cl)) {
                l++;
                if (l >= s.length()) {
                    cl = 'a';
                    break;
                }
                cl = s.charAt(l);
            }

            while (!Character.isLetterOrDigit(cr)) {
                r--;
                if (r < 0) {
                    cr = 'a';
                    break;
                }
                cr = s.charAt(r);
            }

            cl = Character.toLowerCase(cl);
            cr = Character.toLowerCase(cr);

            if (cl == cr) {
                r--;
                l++;
            } else {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    /**
     * 136. 只出现一次的数字
     * https://leetcode-cn.com/problems/single-number/
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }

        System.out.println("ans=" + ans + ",nums=" + Arrays.toString(nums));
        return ans;
    }

    /**
     * 821. 字符的最短距离
     * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
     * 1 <= s.length <= 104
     * s[i] 和 c 均为小写英文字母
     * 题目数据保证 c 在 s 中至少出现一次
     */
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] ans = new int[len]; // 结果数组

        int cSize = 0; // 字符c出现的次数
        int[] cArr = new int[len]; // 字符c出现的位置, 从0开始

        // 提取所有字符c的位置
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);

            if (c1 == c) {
                cArr[cSize++] = i;
            }
        }

        // 遍历数组, 计算每个字符与所有字符c的距离, 并保存最小距离
        for (int i = 0; i < len; i++) {
            int minDis = len;
            for (int j = 0; j < cSize; j++) {
                minDis = Math.min(minDis, Math.abs(i - cArr[j]));
                if (minDis == 0) {
                    break;
                }
            }
            ans[i] = minDis;
        }

        System.out.println(Arrays.toString(ans));
        return ans;
    }

    /**
     * 191. 位1的个数
     * https://leetcode-cn.com/problems/number-of-1-bits/
     */
    public int hammingWeight(int n) {
        // 位移运算
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ans++;
            }
        }
        // System.out.println("ans=" + ans);
        return ans;
//        int ans = 0;
//        String s = Integer.toBinaryString(n);
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '1') {
//                ans++;
//            }
//        }
//
//        System.out.println("ans=" + ans);
//        return ans;
    }

    /**
     * 203. 移除链表元素
     * https://leetcode-cn.com/problems/remove-linked-list-elements/
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode nHead = null;
        while (cur != null) {
            if (cur.val == val) {
                if (prev != null) {
                    prev.next = cur.next;
                }
            } else if (nHead == null) {
                nHead = cur;
                prev = cur;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }

        System.out.println(nHead);
        return nHead;
    }

    /**
     * 388. 文件的最长绝对路径
     * https://leetcode-cn.com/problems/longest-absolute-file-path/
     * <p>
     * 输入：input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
     * 输出：20
     */
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        while (pos < n) {
            // 检测当前文件的深度
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }

            // 统计当前文件名的长度
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            // 跳过当前的换行符
            pos++;

            // 弹出之前层级数据
            while (stack.size() >= depth) {
                sum -= stack.pop();
            }

            // 若非文件,则增加文件分隔符
            if (!isFile) {
                len++;
            }

            // 当前文件名长度入栈
            stack.push(len);
            sum += len; // 当前文件路径长度

            if (isFile) { // 普通文件时, 计算最大深度
                ans = Math.max(ans, sum);
            }
        }
        System.out.println("ans=" + ans);
        return ans;
    }

    /**
     * 824. 山羊拉丁文
     * https://leetcode-cn.com/problems/goat-latin/
     */
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        int len = sentence.length();
        String lastA = "a";
        for (int i = 0; i < len; ) {
            int j = i;
            while (j < len && sentence.charAt(j) != ' ') j++; // 找到单词结尾位置

            if ("aeiouAEIOU".indexOf(sentence.charAt(i)) >= 0) { // 检测到元音开头
                sb.append(sentence, i, j).append("ma");
            } else {
                sb.append(sentence, i + 1, j).append(sentence.charAt(i)).append("ma");
            }
            i = j + 1;
            sb.append(lastA);
            lastA += "a";

            if (i < len) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    /**
     * 396. 旋转函数
     * https://leetcode-cn.com/problems/rotate-function/
     * <p>
     * nums = [4,3,2,6]
     * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
     * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
     * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
     * <p>
     * F(0) = 0*nums[0] + 1*nums[1] + 2*nums[2] + 3*nums[3]
     * F(1) = 0*nums[3] + 1*nums[0] + 2*nums[1] + 3*nums[2]
     * F(2) = 0*nums[2] + 1*nums[3] + 2*nums[0] + 3*nums[1]
     * 即:
     * F(0) = 0*nums[0] + 1*nums[1] + 2*nums[2] + 3*nums[3]
     * F(1) = 1*nums[0] + 2*nums[1] + 3*nums[2] + 0*nums[3] = F(0) + sumNums - 4*nums[3] = F(0) + sumNums - len*nums[len-n]
     * F(2) = 2*nums[0] + 3*nums[1] + 0*nums[2] + 1*nums[3] = F(1) + sumNums - 4*nums[2] = F(0) + sumNums - len*nums[len-n]
     * 其中: sumNums 是所有数组元素求和  len表示数组元素个数
     */
    public int maxRotateFunction(int[] nums) {
        int sumNums = Arrays.stream(nums).sum();
        int len = nums.length;
        int fn = 0;
        for (int i = 0; i < len; i++) { // 求 F(0)
            fn += i * nums[i];
        }
        int max = fn;
        // 求F(1)...F(len-1)
        for (int i = 1; i < len; i++) {
            fn += sumNums - len * nums[len - i];
            max = Math.max(max, fn);
        }
        System.out.println(max);
        return max;
    }

    /**
     * 11. 盛最多水的容器
     * https://leetcode-cn.com/problems/container-with-most-water/
     * 暴力解法
     * 双循环计算所有可能的容器宽高, 但数据量大的时候会运行超时, 如: 11.txt
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int n = height.length;
        for (int i = 0; i < n - 1; i++) {
            int h1 = height[i];
            for (int j = i + 1; j < n; j++) {
                int h2 = height[j];
                int h = Math.min(h1, h2);
                int w = j - i;
                ans = Math.max(ans, w * h);
            }
        }
        System.out.println(ans);
        return ans;
    }

    /**
     * 11. 盛最多水的容器
     * https://leetcode-cn.com/problems/container-with-most-water/
     * 示例:
     * height = 1, 8, 6, 2, 5, 4, 8, 3, 7
     * index  = 0, 1, 2, 3, 4, 5, 6, 7, 8
     * <p>
     * 双指针解法, 假设初始水槽 (i,j), i=0,j=8, 则
     * 向内移动短板, 水槽容积可能会变大
     * 向内移动长板, 水槽容积肯定变小
     * 因此, 循环向内移动短板并比较容积最大值即可
     * <p>
     * 既然有向内移动短板的操作,应该也可以向外移动短板的操作,但初始容器无法确定
     * 需要找到最小容器位置再向外扩展
     */
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(ans);
        return ans;
    }

    /**
     * 15. 三数之和
     * https://leetcode-cn.com/problems/3sum/
     * 暴力解法: 三循环
     * 由于要求答案不重复, 因此先对数组排序, 然后使用 set 数据结构进行去重
     * 这样对 15.txt 3000个元素,我macOS i7-4870HQ 16G内存 耗时14924ms
     */
    public List<List<Integer>> threeSum(int[] nums) {
        long start = System.currentTimeMillis();
        Arrays.sort(nums);// 先对原数组进行升序排序
        Set<List<Integer>> set = new HashSet<>();//数据结构使用 hashSet

        // 三轮循环
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // 数组已排序, 若前两个元素和大于0,则再加一个后续元素肯定最终大于0
                    // 增加本优化判断后 耗时减少到 7538ms
                    if (nums[i] + nums[j] > 0) {
                        break;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> element = new ArrayList<>();
                        element.add(nums[i]);
                        element.add(nums[j]);
                        element.add(nums[k]);
                        set.add(element);
                    }
                }
            }
        }

        System.out.println("耗时01: " + (System.currentTimeMillis() - start) + "ms, size=" + set.size());
        return new ArrayList<>(set);
    }

    /**
     * 15. 三数之和
     * https://leetcode-cn.com/problems/3sum/
     * 排序 + 双指针
     * 确定了第一个元素后, 剩下的两个元素就可以使用双指针
     * 由于数组已排序,因此 L = i + 1,  R = n -1
     * 若 nums[i] + nums[L] + nums[R] > 0 ,则右指针往左移动,反之左指针向右移动
     * 相比于三重排序的暴力解法, 该方法耗时38ms
     */
    public List<List<Integer>> threeSum02(int[] nums) {
        long start = System.currentTimeMillis();
        Arrays.sort(nums);// 先对原数组进行升序排序
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) { // 和大于0时, 由于数组已排序,则右指针往左移动, 和才会减小
                    r--;
                } else if (sum < 0) { // 和小于0, 由于数组已排序, 需要左指针往右移动, 和才会增大,才有可能变成0
                    l++;
                } else {
                    List<Integer> element = new ArrayList<>();
                    element.add(nums[i]);
                    element.add(nums[l]);
                    element.add(nums[r]);
                    set.add(element);


                    // 继续寻找下一组答案, 双指针继续向内移动
                    l++;
                    r--;

                    // 由于需要去重, 因此若左指针移动前后的两个元素若相同,则继续移动, 右指针同理
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }

        if (set.size() < 10) {
            System.out.println("耗时02: " + (System.currentTimeMillis() - start) + "ms, size=" + set.size() + ",ans*" + set);
        } else {
            System.out.println("耗时02: " + (System.currentTimeMillis() - start) + "ms, size=" + set.size());

        }
        return new ArrayList<>(set);
    }

    /**
     * 868. 二进制间距
     * https://leetcode-cn.com/problems/binary-gap/
     */
    public int binaryGap(int n) {
        int pos = 0;
        int dis = 0; // 最大间距值
        int lastOneIndex = -1; // 上一个1的位置
        while (pos < Integer.SIZE) {
            if ((n & (1 << pos)) > 0) { // 按位与, 找到一个1
                if (lastOneIndex >= 0) { // 已存在1, 则求距离
                    dis = Math.max(dis, pos - lastOneIndex);
                }
                lastOneIndex = pos;
            }
            pos++;
        }

        System.out.println("dis=" + dis);
        return dis;
    }

    /**
     * 1732. 找到最高海拔
     * https://leetcode-cn.com/problems/find-the-highest-altitude/
     * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔
     * gain[i] = h[i+1] - h[i]
     * h[0] = 0
     * h[1] = h[0] + gain[0] = gain[0]
     * h[2] = gain[1] + h[1] = gain[0] + gain[1]
     * ....
     * h[i] = gain[0] + gain[1] + ... gain[i-1]
     * <p>
     * 点     0    1    2   3   4   5   6
     * gain       -5    1   5   0   7
     * 海拔   0    -5   -4   1
     */
    public int largestAltitude(int[] gain) {
        int maxH = 0;
        int h = 0;
        for (int j : gain) {
            h += j; // 求当前位置的海拔
            maxH = Math.max(h, maxH); // 计算最高海拔
        }
        System.out.println(maxH);
        return maxH;
    }

    /**
     * 1404. 将二进制表示减到 1 的步骤数 中等
     * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
     * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
     * 如果当前数字为偶数，则将其除以 2
     * 如果当前数字为奇数，则将其加上 1
     * 题目保证你总是可以按上述规则将测试用例变为 1
     * <p>
     * 难怪会是中等, 需要考虑越界情况,如:  "1111011110000011100000110001011011110010111001010111110001"
     * 因此不能用Integer.parseInt(s, 2) 求得整数
     */
    public int numSteps(String s) {
        int steps = 0;
        while (!Objects.equals(s, "1")) {
            int len = s.length();
            if (len < Integer.SIZE) { // 字符串长度可以用整数表示时, 直接转换为整数求解
                break;
            }
            if (s.charAt(len - 1) == '1') { // 奇数加1
                int pos = len - 1;
                int carry = 1; // 首次计算时, 表示题目要求的加1, 后续计算则表示进位
                char[] arr = new char[len + 1];
                while (pos >= 0) {
                    char c = s.charAt(pos);
                    int cI = c == '0' ? 0 : 1;
                    int sum = cI + carry;
                    carry = sum / 2;
                    arr[pos + 1] = sum % 2 == 1 ? '1' : '0';
                    pos--;
                }
                arr[0] = carry == 1 ? '1' : '0';

                // 去除前导0
                int index = 0;
                for (int i = 0; i < len + 1; i++) {
                    if (arr[i] != '0') {
                        index = i;
                        break;
                    }
                }
                arr = Arrays.copyOfRange(arr, index, len + 1);
                s = String.valueOf(arr); // 获取结果字符串
            } else { // 偶数除以2, 等于向右移位, 等效于截取字符串前n位
                s = s.substring(0, s.length() - 1);
            }
            steps++;
        }

        // 整数求解
        int n = Integer.parseInt(s, 2);
        while (n != 1) {
            if (n % 2 == 1) { // 奇数
                n++;
            } else {
                n = n / 2;
            }
            steps++;
        }
        System.out.println(steps);
        return steps;
    }

    /**
     * 剑指 Offer II 015. 字符串中的所有变位词
     * https://leetcode-cn.com/problems/VabMRr/
     */
    public List<Integer> findAnagrams(String s, String p) {
        int ns = s.length();
        int np = p.length();
        List<Integer> ans = new ArrayList<>();
        if (ns < np) {
            return ans;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < np; i++) {
            char c = p.charAt(i);
            updateMap(pMap, c, true);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int sMapSum = 0;
        int l = 0, r = 0;
        while (l <= r && r < ns) {
            char c = s.charAt(r);
            if (pMap.containsKey(c)) { // 若当前位符合预期,则将其加入待定列表
                int sCount = updateMap(sMap, c, true);
                sMapSum++;
                int pCount = pMap.get(c);
                if (pCount < sCount) { // 若当前字符个数已超预期树,则左指针右移直到数量相等
                    for (int i = l; i < r; i++) {
                        char c1 = s.charAt(l);
                        updateMap(sMap, c1, false);
                        sMapSum--;
                        l = i + 1;
                        if (c1 == c) {
                            break;
                        }
                    }
                }
            } else { // 若检索到非预期字符,则清空sMap,总字符数清零,从下一位开始从头计算
                sMap.clear();
                sMapSum = 0;
                l = r + 1;
            }
            r++;

            // 字符总个数达到预期
            if (sMapSum == np) {
                // 比较是否是变位词, 若是,则将起始位置l加入答案
                if (pMap.equals(sMap)) {
                    ans.add(l);
                }

                // 左指针右移移位,开始下一轮子串的判断
                updateMap(sMap, s.charAt(l), false);
                sMapSum--;
                l++;
            }
        }

        System.out.println(ans);
        return ans;
    }

    /**
     * 更新map指定key的value
     *
     * @param increase true-value值加1 false-value值减1, 减到0时,将key从map中移除
     * @return 指定key的value值
     */
    private int updateMap(Map<Character, Integer> map, Character c, boolean increase) {
        int count = map.getOrDefault(c, 0);
        count = increase ? count + 1 : count - 1;
        if (count <= 0) {
            map.remove(c);
        } else {
            map.put(c, count);
        }
        return Math.max(0, count);
    }

    /**
     * 1305. 两棵二叉搜索树中的所有元素
     * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = inorderTraversal2(root1);
        List<Integer> list2 = inorderTraversal2(root2);
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = 0;
        int n1 = list1.size();
        int n2 = list2.size();
        while (l < n1 || r < n2) {
            Integer item1 = l < n1 ? list1.get(l) : Integer.MAX_VALUE;
            Integer item2 = r < n2 ? list2.get(r) : Integer.MAX_VALUE;

            if (item1 <= item2) {
                ans.add(item1);
                l++;
            } else {
                ans.add(item2);
                r++;
            }
        }
        System.out.println(ans);
        return ans;
    }

    /**
     * 1647. 字符频次唯一的最小删除次数
     * https://leetcode-cn.com/problems/minimum-deletions-to-make-character-frequencies-unique/
     */
    public int minDeletions(String s) {
        // 遍历统计所有字符的频次, 字符串只包含小写字母,共计26个
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            freq[index] = freq[index] + 1;
        }

        // 若某频次已出现,则删除一个字符,该字符频次减1,重新比价频次
        int ans = 0; // 要删减的此树
        Set<Integer> freqSet = new HashSet<>(); // 使用set存储已出现过的频次
        for (int i = 0; i < 26; i++) {
            int cnt = freq[i];
            while (freqSet.contains(cnt) && cnt > 0) {
                cnt--;
                ans++;
            }

            if (cnt > 0) {
                freqSet.add(cnt);
            }
        }
        System.out.println("ans=" + ans);
        return ans;
    }
}