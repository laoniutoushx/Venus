package haruhi.sys.kit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicSysKit {
	/**
	 * 把(22)(33)(55)取出形成List
	 * @param str
	 * @return
	 */
	public static List<Integer> braceStr2List(String str) {
		Pattern pattern = Pattern.compile("(\\d+)");
		Matcher m = pattern.matcher(str);
		List<Integer> list = new ArrayList<Integer>();
		while(m.find()) {
			list.add(Integer.parseInt(m.group()));
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if(obj==null) return true;
		if(obj instanceof String) {
			if("".equals(obj)) return true;
		}
		if(obj instanceof Collection<?>) {
			if(((Collection) obj).size()>0) return true;
		}
		return false;
	}
	
	public static <N extends Object>void mergeList(List<N> baseList,List<N> mergeList) {
		for(N o:mergeList) {
			if(!baseList.contains(o)) {
				baseList.add(o);
			}
		}
	}
}
