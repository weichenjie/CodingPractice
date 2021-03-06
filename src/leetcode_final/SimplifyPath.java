package leetcode_final;
/*
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = path.length();
		if(len == 0)
			return "/";
		Stack<String> stack = new Stack<String>();
		int right, i = 0;
		String part;
		while(i < len){
			if(path.charAt(i) == '/'){
				right = i + 1;
				while(right < len && path.charAt(right) != '/')
					right++;
				part = path.substring(i + 1, right);
				i = right;
				if(part.length() == 0)
					continue;
				if(part.equals("..")){// 返回上级目录
					if(!stack.empty())
						stack.pop();
				}
				else if(part.equals("."));// 忽略
				else// 有效路径
					stack.push(part);
				
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.empty()){
			sb.insert(0, stack.pop());
			sb.insert(0, "/");
		}
		if(sb.length() == 0)
			return "/";
		else
			return sb.toString();
	}
	public static void main(String[] args){
		SimplifyPath test = new SimplifyPath();
		test.simplifyPath("/");
	}
}
