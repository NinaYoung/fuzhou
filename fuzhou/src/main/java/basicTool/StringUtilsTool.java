package basicTool;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTool extends StringUtils {
	
	public static boolean isNotEmpty(CharSequence cs) {
		return StringUtils.isNotEmpty(cs);
	}
	
	public static boolean isNoneEmpty(CharSequence[] css) {
		return StringUtils.isNoneEmpty(css);
	}
	
	/**
	 * 
	 * @param num  循环次数
	 * @param str  要循环的字符
	 * @return
	 */
	public String appendToStringBuffer(int num,String str){
		StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<num;i++){
        	stringBuffer.append(str);
        }
        return stringBuffer.toString();
	}
}
