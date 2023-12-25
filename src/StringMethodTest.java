import java.util.Arrays;

/**
 * @author Chiuder
 * @BelongsPackage: PACKAGE_NAME
 * @Description
 * @create 2022-12-07 13:39
 */
public class StringMethodTest {

    public static void main(String[] args) {
        Double a = 100.00;
        Double b = a;
        System.out.println(a.equals(b));
        /*
        String类是Java最常用的API，它包含了大量处理字符串的方法，比较常用的有：
        char charAt(int index)：返回指定索引处的字符；
        String substring(int beginIndex, int endIndex)：从此字符串中截取出一部分子字符串；
        String[] split(String regex)：以指定的规则将此字符串分割成数组；
        String trim()：删除字符串前导和后置的空格；
        int indexOf(String str)：返回子串在此字符串首次出现的索引；
        int lastIndexOf(String str)：返回子串在此字符串最后出现的索引；
        boolean startsWith(String prefix)：判断此字符串是否以指定的前缀开头；
        boolean endsWith(String suffix)：判断此字符串是否以指定的后缀结尾；
        String toUpperCase()：将此字符串中所有的字符大写；
        String toLowerCase()：将此字符串中所有的字符小写；
        String replaceFirst(String regex, String replacement)：用指定字符串替换第一个匹配的子串；
        String replaceAll(String regex, String replacement)：用指定字符串替换所有的匹配的子串。
         **/
        String ch = "hello world! ";
        System.out.println(ch.charAt(0));
        System.out.println(ch.substring(0,5));//左闭右开
        System.out.println(Arrays.toString(ch.split("")));
        System.out.println(ch.trim());
        System.out.println(ch.indexOf("ll"));
        System.out.println(ch.lastIndexOf("l"));
        System.out.println(ch.toUpperCase());
        System.out.println(ch.toLowerCase());
        System.out.println(ch.replaceFirst("l", "o"));
        System.out.println(ch.replaceAll("l", "o"));
        StringBuffer str1 = new StringBuffer("hello");
        StringBuilder str2 = new StringBuilder("world");
        System.out.println(str1.append("!!!"));
        System.out.println(str2.append("!!!"));
        System.out.println(ch.concat(str2.toString()));
        System.out.println(ch.concat(str1.toString()));

    }


}
