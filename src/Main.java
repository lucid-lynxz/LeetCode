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

//        // 144. 二叉树的前序遍历
//        System.out.println(solution.preorderTraversal(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, null, 2, 3}))); // [1,2,3]
//        System.out.println(solution.preorderTraversal(TreeNodeUtil.arrayToTreeNode(new Integer[]{}))); // []
//        System.out.println(solution.preorderTraversal(TreeNodeUtil.arrayToTreeNode(new Integer[]{1}))); // [1]
//        System.out.println(solution.preorderTraversal(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 2}))); // [1,2]

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

        // 821. 字符的最短距离
//        solution.shortestToChar("loveleetcode", 'e'); // [3,2,1,0,1,0,0,1,2,2,1,0]
//        solution.shortestToChar("aaab", 'b'); // [3,2,1,0]

        // 191. 位1的个数
//        solution.hammingWeight(0b00000000000000000000000000001011); // 3
//        solution.hammingWeight(0b00000000000000000000000010000000); // 1
//        solution.hammingWeight(0b11111111111111111111111111111101); // 31

        // 203. 移除链表元素
//        solution.removeElements(LinkUtil.makeListNode(1, 2, 6, 3, 4, 5, 6), 6); // [1,2,3,4,5]
//        solution.removeElements(LinkUtil.makeListNode(), 1); // []
//        solution.removeElements(LinkUtil.makeListNode(7, 7, 7, 7), 7); // []
//        solution.removeElements(LinkUtil.makeListNode(1, 2, 2, 1), 2); // [1,1]

        // 388. 文件的最长绝对路径
//        solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"); // 20
//        solution.lengthLongestPath("a"); // 0
//        solution.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"); // 12
//        solution.lengthLongestPath("a.txt"); //5

        //824. 山羊拉丁文
//        solution.toGoatLatin("I speak Goat Latin"); // Imaa peaksmaaa oatGmaaaa atinLmaaaaa
//        solution.toGoatLatin("The quick brown fox jumped over the lazy dog"); // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
//        solution.toGoatLatin("HZ sg L"); // ZHmaa gsmaaa Lmaaaa
//        solution.toGoatLatin("Each word consists of lowercase and uppercase letters only"); // Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa

        // 396. 旋转函数
//        solution.maxRotateFunction(new int[]{4, 3, 2, 6}); // 26
//        solution.maxRotateFunction(new int[]{100}); // 0
//        solution.maxRotateFunction(new int[]{-8, -5}); // -5

        // 11. 盛最多水的容器
//        solution.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}); // 49
//        solution.maxArea2(new int[]{1, 1}); // 1

        // 15. 三数之和
//        solution.threeSum02(new int[]{-1, 0, 1, 2, -1, -4}); // [[-1,-1,2],[-1,0,1]]
//        solution.threeSum02(new int[]{}); // []
//        solution.threeSum02(new int[]{0}); // []
//        solution.threeSum02(new int[]{0, 0, 0}); // [0,0,0]
//        int[] nums = ArrayUtil.INSTANCE.readByFile("assets/large_arr_case/15.txt");
//        solution.threeSum(nums);
//        solution.threeSum02(nums);

        // 868. 二进制间距
//        solution.binaryGap(22); // 2
//        solution.binaryGap(8); // 0
//        solution.binaryGap(5); // 2

        // 1732. 找到最高海拔
//        solution.largestAltitude(new int[]{-5, 1, 5, 0, -7}); // 1
//        solution.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}); //  0

        // 1404. 将二进制表示减到 1 的步骤数
//        solution.numSteps("1101"); // 6
//        solution.numSteps("10"); // 1
//        solution.numSteps("1"); // 0
//        solution.numSteps("1111011110000011100000110001011011110010111001010111110001"); // 85
//        solution.numSteps("100100001010010101101000111100100111101111000111111010010001100001000100011001"); // 120

        // 剑指 Offer II 015. 字符串中的所有变位词
//        solution.findAnagrams("cbaebabacd", "abc"); // [0,6]
//        solution.findAnagrams("abab", "ab"); // [0,1,2]
//        solution.findAnagrams("abaacbabc", "abc"); // [3,4,6]
//        solution.findAnagrams("baa", "aa"); // [1]

        // 1305. 两棵二叉搜索树中的所有元素
//        solution.getAllElements(TreeNodeUtil.arrayToTreeNode(new Integer[]{2, 1, 4}), TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 0, 3})); // 0,1,1,2,3,4
//        solution.getAllElements(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, null, 8}), TreeNodeUtil.arrayToTreeNode(new Integer[]{8, 1})); // 1,1,8,8

        // 1647. 字符频次唯一的最小删除次数
//        solution.minDeletions("aab"); // 0
//        solution.minDeletions("aaabbbcc"); // 2
//        solution.minDeletions("ceabaacb"); // 2
//        solution.minDeletions("a"); // 0


        // 128. 最长连续序列
//        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
//        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
//        System.out.println(solution.longestConsecutive(new int[]{0, 0})); // 1
//        System.out.println(solution.longestConsecutive(new int[]{1, 2, 0, 1})); // 3
//
//        System.out.println(solution.longestConsecutive_hash(new int[]{100, 4, 200, 1, 3, 2})); // 4
//        System.out.println(solution.longestConsecutive_hash(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
//        System.out.println(solution.longestConsecutive_hash(new int[]{0, 0})); // 1
//        System.out.println(solution.longestConsecutive_hash(new int[]{1, 2, 0, 1})); // 3

        // 538. 把二叉搜索树转换为累加树
//        TreeNode node = solution.convertBST(TreeNodeUtil.arrayToTreeNode(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8}));
//        System.out.println(solution.levelOrder(node)); // [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

        // 剑指 Offer II 027. 回文链表
//        System.out.println(solution.isPalindrome(LinkUtil.makeListNode(1, 2, 3, 3, 2, 1))); // true
//        System.out.println(solution.isPalindrome(LinkUtil.makeListNode(1, 2))); // false
//        System.out.println(solution.isPalindrome(LinkUtil.makeListNode(1, 2, 1))); // true
//        System.out.println(solution.isPalindrome(LinkUtil.makeListNode())); // true

        // 面试题 02.02. 返回倒数第 k 个节点
//        System.out.println(solution.kthToLast(LinkUtil.makeListNode(1, 2, 3, 4, 5), 2)); // 4

        // 961. 在长度 2N 的数组中找出重复 N 次的元素
//        System.out.println(solution.repeatedNTimes(new int[]{1, 2, 3, 3})); // 3
//        System.out.println(solution.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2})); // 2
//        System.out.println(solution.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4})); // 5

        // 436. 寻找右区间
//        System.out.println(Arrays.toString(solution.findRightInterval2(new int[][]{{3, 4}, {2, 3}, {1, 2}}))); // [-1,0,1]
//        System.out.println(Arrays.toString(solution.findRightInterval2(new int[][]{{1, 2}}))); // [-1]
//        System.out.println(Arrays.toString(solution.findRightInterval2(new int[][]{{1, 4}, {2, 3}, {3, 4}}))); // [-1,2,-1]
//        System.out.println(Arrays.toString(solution.findRightInterval2(new int[][]{{1, 1}, {3, 4}}))); // [0,-1]

        // 923. 三数之和的多种可能
//        System.out.println(solution.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8)); // 20
//        System.out.println(solution.threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5)); // 12

        // 1090. 受标签影响的最大值
//        System.out.println(solution.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1)); // 9
//        System.out.println(solution.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2)); // 12
//        System.out.println(solution.largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 1)); // 16

        // 1022. 从根到叶的二进制数之和
//        System.out.println(solution.sumRootToLeaf(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 0, 1, 0, 1, 0, 1}))); // 22
//        System.out.println(solution.sumRootToLeaf(TreeNodeUtil.arrayToTreeNode(new Integer[]{0}))); // 0

        // 473. 火柴拼正方形
//        System.out.println(solution.makesquare(new int[]{1, 2, 2, 2, 1})); // true
//        System.out.println(solution.makesquare(new int[]{3, 3, 3, 3, 4})); // false

        // 1200. 最小绝对差
//        System.out.println(solution.minimumAbsDifference(new int[]{4, 2, 1, 3})); // [[1,2],[2,3],[3,4]]
//        System.out.println(solution.minimumAbsDifference(new int[]{1, 3, 6, 10, 15})); // [[1,3]]
//        System.out.println(solution.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27})); // [[-14,-10],[19,23],[23,27]]

//        // 729. 我的日程安排表 I
//        MyCalendar myCalendar = new MyCalendar();
//        // ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
//        // [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
//        int[][] srcArrs = new int[][]{
//                {47, 50}, {33, 41}, {39, 45}, {33, 42}, {25, 32}, {26, 35}, {19, 25}, {3, 8}, {8, 13}, {18, 27}};
//        // 预期结果: [true,  true,   false,     false,    true,     false,     true,    true,   true,    false]
//        List<Boolean> ans = new ArrayList<>();
//        for (int[] item : srcArrs) {
//            ans.add(myCalendar.book(item[0], item[1]));
//        }
//        System.out.println(ans);

        // 1018. 可被 5 整除的二进制前缀
//        System.out.println(solution.prefixesDivBy5(new int[]{0, 1, 1})); // [true,false,false]
//        System.out.println(solution.prefixesDivBy5(new int[]{1, 1, 1})); // [false,false,false]
//        // [false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,true,true,true,true,false]
//        System.out.println(solution.prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));

        // 648. 单词替换
//        solution.replaceWords(ListUtil.convert("cat", "bat", "rat"),
//                "the cattle was rattled by the battery",
//                "the cat was rat by the bat");
//
//        solution.replaceWords(ListUtil.convert("a", "b", "c"),
//                "aadsfasf absbs bbab cadsfafs",
//                "a a b c");
//
//        solution.replaceWords(ListUtil.convert("e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm", "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm", "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem", "xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz", "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref", "qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw"),
//                "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp",
//                "i miszkays w gvcfldkiavww v dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dc k w ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy i mengfdydekwttkhbzenk w h ldipovluo a nusquzpmnogtjkklfhta k nxzgnrveghc mpppfhzjkbucv c uwmahhqradjtf i z q yzfragcextvx i i j gzixfeugj rnukjgtjpim h a x h ygelddphxnbh rvjxtlqfnlmwdoezh z i bbfj mhs nenrqfkbf spfpazr w c dtd c dtaxhddidfwqs bgnnoxgyynol h dijhrrpnwjlju muzzrrsypzgwvblf z h q i daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh q i k bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala q gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn f c pxbd oklwhcppuziixpvihihp");

        // 1217. 玩筹码
//        solution.minCostToMoveChips(new int[]{1, 2, 3}, 1);
//        solution.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}, 2);
//        solution.minCostToMoveChips(new int[]{1, 1000000000}, 1);
//        solution.minCostToMoveChips2(new int[]{1, 2, 3}, 1);
//        solution.minCostToMoveChips2(new int[]{2, 2, 2, 3, 3}, 2);
//        solution.minCostToMoveChips2(new int[]{1, 1000000000}, 1);

        // 873. 最长的斐波那契子序列的长度
//        solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5);
//        solution.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}, 3);
//        solution.lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}, 5);
//
//        solution.lenLongestFibSubseq2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5);
//        solution.lenLongestFibSubseq2(new int[]{1, 3, 7, 11, 12, 14, 18}, 3);
//        solution.lenLongestFibSubseq2(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}, 5);

        // 501. 二叉搜索树中的众数
        solution.findMode(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, null, 2, 2})); // [2]
        solution.findMode(TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 1, 2, 2})); // [1,2]
        solution.findMode(TreeNodeUtil.arrayToTreeNode(new Integer[]{0})); // [0]
    }
}