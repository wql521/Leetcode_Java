//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8726 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 无重复字符的最长子串
 * @author 1Fan-CheN
 * @date 2023-02-17 23:19:05
 */
 
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串().new Solution();
    }

    @Test
    public void test(){
        String s = "abc";
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> list = new ArrayList<>();
        int result = 1;
        //获取所有字符串
        String pattern = "[a-zA-Z]+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        while (m.find()){
            String s1 = m.group();
            char[] chars = s1.toCharArray();
            int rec = 1;
            for (int i = 0; i < chars.length; i++) {
                String temp = "";
                String str = String.valueOf(chars[i]);
                temp = temp+str;
                for (int j = i+1; j < chars.length;j++) {
                    String str1 = String.valueOf(chars[j]);
                    if (!temp.contains(str)){
                        temp = temp+str1;
                    }else{
                        break;
                    }
                }
                if (temp.length()> rec){
                    rec = temp.length();
                }
            }
            if (rec > result ){
                result = rec;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
