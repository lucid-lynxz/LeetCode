import util.TreeNodeUtil;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println("PAYPALISHIRING,3  --> " + solution.convert("PAYPALISHIRING", 3));
//        System.out.println("PAYPALISHIRING,4  --> " + solution.convert("PAYPALISHIRING", 4));
//        System.out.println("PAYPALISHIRING,41  --> " + solution.convert("PAYPALISHIRING", 41));
//        System.out.println("a,2  --> " + solution.convert("a", 2));
//        System.out.println("a,1  --> " + solution.convert("a", 1));
//        System.out.println("ab,1  --> " + solution.convert("ab", 1));
//        System.out.println("ab,2  --> " + solution.convert("ab", 2));
//        System.out.println("ab,20  --> " + solution.convert("ab", 20));
//        System.out.println("abc,1  --> " + solution.convert("abc", 1));

        //  7. 整数反转
//        solution.reverse(-12); // -21
//        solution.reverse(-1); // -1
//        solution.reverse(123); // 321
//        solution.reverse(-123); // -321
//        solution.reverse(120); // 21
//        solution.reverse(0); // 0
//        solution.reverse(Integer.MAX_VALUE); // 2147483647 -> 0
//        solution.reverse(Integer.MIN_VALUE); // -2147483648 -> 0
//        solution.reverse(1534236469); // 0
//        solution.reverse(1563847412); // 0
//        solution.reverse(1463847412); // 2147483641

        // 8. 字符串转换整数 (atoi)
//        solution.myAtoi("   1"); // 1
//        solution.myAtoi("   1ab234"); // 1
//        solution.myAtoi("   +1ab234"); // 1
//        solution.myAtoi("   -1ab234"); // -1
//        solution.myAtoi("42"); // 42
//        solution.myAtoi("   -42"); // -42
//        solution.myAtoi("4193 with words"); // 4193
//        solution.myAtoi(" +4193 with words"); // 4193
//        solution.myAtoi("-abc4193 with words234"); // 0
//        solution.myAtoi("+2147483648 with words234"); // 2147483647 (超过最大值, 取最大值)
//        solution.myAtoi("-2147483649 with words234"); // -2147483648 (小于最小值, 取最小值)
//        solution.myAtoi("-91283472332"); // -2147483648 (小于最小值, 取最小值)
//        solution.myAtoi("+-12"); // 0
//        solution.myAtoi("   - 42"); // 0
//        solution.myAtoi("   -42+233"); // -42
//        solution.myAtoi("21474836460"); // 2147483647
//        solution.myAtoi("00000-42a1234"); // 0

//        // 9. 回文数
//        solution.isPalindrome(123);
//        solution.isPalindrome(-121);
//        solution.isPalindrome(10);
//        solution.isPalindrome(Integer.MAX_VALUE);
//        solution.isPalindrome(Integer.MIN_VALUE);
//        solution.isPalindrome(746388364);
//        solution.isPalindrome(46388364);

//        // 13. 罗马数字转整数
//        solution.romanToInt("III"); // 3
//        solution.romanToInt("IV"); // 4
//        solution.romanToInt("IX"); // 9
//        solution.romanToInt("LVIII"); // 58
//        solution.romanToInt("MCMXCIV"); // 1994
//        solution.romanToInt("CMXCIX"); // 999

        // 14. 最长公共前缀
//        solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}); // fl
//        solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}); // ""
//        solution.longestCommonPrefix(new String[]{""}); // ""
//        solution.longestCommonPrefix(new String[]{"dog"}); // "dog"
//        solution.longestCommonPrefix(new String[]{"abab", "aba", ""}); // ""


//        // 20.有效的括号
//        solution.isValid("()"); // true
//        solution.isValid("()[]{}"); // true
//        solution.isValid("(]"); // false
//        solution.isValid("([)]"); // false
//        solution.isValid("{[]}"); // true
//        solution.isValid("))))"); // false
//        solution.isValid(")"); // false

        // 21. 合并两个有序链表
//        solution.mergeTwoLists(solution.makeListNode(1, 2, 4), solution.makeListNode(1, 3, 4)); // 1,1,2,3,4,4
//        solution.mergeTwoLists(solution.makeListNode(), solution.makeListNode()); // 空
//        solution.mergeTwoLists(solution.makeListNode(), solution.makeListNode(0)); // 0

        // 27. 移除元素
//        solution.removeElement(new int[]{3, 2, 2, 3}, 3); // 2  [2,2]
//        solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2); // 5  [0,1,4,0,3]
//        solution.removeElement(new int[]{0}, 0); // 0  []
//        solution.removeElement(new int[]{2,2,2,2}, 2); // 0  []
//        solution.removeElement(new int[]{2,3}, 2); // 1  [3]
//        solution.removeElement(new int[]{}, 2); // 0  []
//        solution.removeElement(new int[]{50}, 2); // 1  [50]

        // 28. 实现 strStr()
//        solution.strStr("hello", "ll"); // 2
//        solution.strStr("aaaaa", "bba"); // -1
//        solution.strStr("", ""); // 0
//        solution.strStr("ababbba", "bba"); // 4
//        solution.strStr("aaa", "aaaa"); // -1
//        solution.strStr("mississippi", "issipi"); // -1

        // 35. 搜索插入位置
//        solution.searchInsert(new Integer[]{1, 3, 5, 6}, 5); // 2
//        solution.searchInsert(new Integer[]{1, 3, 5, 6}, 2); // 1
//        solution.searchInsert(new Integer[]{1, 3, 5, 6}, 7); // 4
//        solution.searchInsert(new Integer[]{1, 3, 5, 6}, 0); // 0
//        solution.searchInsert(new Integer[]{1}, 0); // 0
//        solution.searchInsert(new Integer[]{1}, 1); // 0
//        solution.searchInsert(new Integer[]{1, 3}, 1); // 0
//        solution.searchInsert(new Integer[]{1, 3}, 3); // 1
//        solution.searchInsert(new Integer[]{1, 2, 3}, 2); // 1

        // 53. 最大子数组和
//        solution.maxSubArray(new Integer[]{-2,1,-3,4,-1,2,1,-5,4}); // 6
//        solution.maxSubArray(new Integer[]{1}); // 1
//        solution.maxSubArray(new Integer[]{5,4,-1,7,8}); // 23

        // 58. 最后一个单词的长度
//        solution.lengthOfLastWord("Hello World"); // 5
//        solution.lengthOfLastWord("   fly me   to   the moon  "); // 4
//        solution.lengthOfLastWord("luffy is still joyboy"); // 6
//        solution.lengthOfLastWord("Hello World"); // 5
//        solution.lengthOfLastWord("H"); // 1
//        solution.lengthOfLastWord(" H           "); // 1

        // 66. 加一
//        solution.plusOne(new int[]{1, 2, 3}); // [1,2,4]
//        solution.plusOne(new int[]{4, 3, 2, 1}); // [4,3,2,2]
//        solution.plusOne(new int[]{0}); // [1]
//        solution.plusOne(new int[]{9, 9, 9}); // [1,0,0,0]
//        solution.plusOne(new int[]{9}); // [1,0]

        //67. 二进制求和
//        solution.addBinary("1","1"); // 10
//        solution.addBinary("1","0"); // 1
//        solution.addBinary("11","1"); // 100
//        solution.addBinary("1010","1011"); // 10101

        //69. x 的平方根
//        solution.mySqrt(9); // 3
//        solution.mySqrt(4); // 2
//        solution.mySqrt(8); // 2
//        solution.mySqrt(1); // 1
//        solution.mySqrt(0); // 0

        // 70. 爬楼梯
//        solution.climbStairs(1); // 1
//        solution.climbStairs(2); // 2
//        solution.climbStairs(3); // 3
//        solution.climbStairs(4); // 5
//        solution.climbStairs(5); // 8
//        solution.climbStairs(43); // 701408733
//        solution.climbStairs(44); // 1134903170
//        solution.climbStairs(45); // 1836311903

        // 83. 删除排序链表中的重复元素
//        solution.deleteDuplicates(solution.makeListNode(1, 1, 2)); // 1,2
//        solution.deleteDuplicates(solution.makeListNode(1, 1, 2, 3, 3)); // 1,2,3

        //88. 合并两个有序数组
//        solution.merge(new int[]{1, 2, 3, 0, 0, 0},3, new int[]{2, 5, 6}, 3); //1,2,2,3,5,6
//        solution.merge(new int[]{1},1, new int[]{}, 0); //1

        // 94. 二叉树的中序遍历
//        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null)); //  1,null,2,3
//        List<Integer> list = solution.inorderTraversal(root);// 1,3,2
//        System.out.println(ListUtil.toString(list));
//
//        list = solution.inorderTraversal(null); // null
//        System.out.println(ListUtil.toString(list));
//
//        list = solution.inorderTraversal(new TreeNode(1)); // 1
//        System.out.println(ListUtil.toString(list));
//
//        list = solution.inorderTraversal(null);
//        System.out.println(ListUtil.toString(list));

        // 144. 二叉树的前序遍历
        System.out.println(solution.preorderTraversal(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, null, 2, 3}))); // [1,2,3]
        System.out.println(solution.preorderTraversal(TreeNodeUtil.arrayToTreeNode(new Integer[]{}))); // []
        System.out.println(solution.preorderTraversal(TreeNodeUtil.arrayToTreeNode(new Integer[]{1}))); // [1]
        System.out.println(solution.preorderTraversal(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 2}))); // [1,2]

        // 100. 相同的树
//        TreeNode pRoot = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null)); //  1,null,2,3
//        TreeNode qRoot = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null)); //  1,null,2,3
//        boolean isSameTree = solution.isSameTree(pRoot, qRoot);// true
//        System.out.println(isSameTree);
//
//        pRoot = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)); //  1,2,3
//        qRoot = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)); //  1,2,3
//        isSameTree = solution.isSameTree(pRoot, qRoot);// true
//        System.out.println(isSameTree);
//
//        pRoot = new TreeNode(1, new TreeNode(2, null, null), null); //  1,2
//        qRoot = new TreeNode(1, null, new TreeNode(2, null, null)); //  1,null,2
//        isSameTree = solution.isSameTree(pRoot, qRoot);// false
//        System.out.println(isSameTree);
//
//        pRoot = new TreeNode(1, new TreeNode(1, null, null), null); //  1,1
//        qRoot = new TreeNode(1, null, new TreeNode(1, null, null)); //  1,null,1
//        isSameTree = solution.isSameTree(pRoot, qRoot);// false
//        System.out.println(isSameTree);

        // 108. 将有序数组转换为二叉搜索树
//        solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});

        // 112. 路径总和
//        solution.hasPathSum(solution.sortedArrayToBST(new int[]{1, 2}), 1, false);
//        solution.hasPathSum(TreeNodeUtil.arrayToTreeNode(new Integer[]{-2, null, -3}), -5, true);
//        solution.hasPathSum(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, -2, -3, 1, 3, -2, null, -1}), -1, true);

        // 113. 路径总和②
//        solution.pathSum(TreeNodeUtil.arrayToTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22); // [[5,4,11,2],[5,8,4,5]]
//        solution.pathSum(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 2, 3}), 5); // []
//        solution.pathSum(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 2}), 0); // []

        // 118. 杨辉三角
//        solution.generate(5); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//        solution.generate(1); // [[1]]

        // 119. 杨辉三角 II
//        solution.getRow(3); // [1,3,3,1]
//        solution.getRow(0); // [1]
//        solution.getRow(1); // [1,1]

        // 121. 买卖股票的最佳时机
//        solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // 5
//        solution.maxProfit(new int[]{7, 6, 4, 3, 1}); // 0
//        solution.maxProfit(new int[]{1, 2}); // 1

        // 125. 验证回文串
//        solution.isPalindrome("A man, a plan, a canal: Panama"); // true
//        solution.isPalindrome("race a car"); // false
//        solution.isPalindrome(".,"); // true

        //136. 只出现一次的数字
//        solution.singleNumber(new int[]{2, 2, 1}); // 1
//        solution.singleNumber(new int[]{4, 1, 2, 1, 2}); // 4
    }
}
