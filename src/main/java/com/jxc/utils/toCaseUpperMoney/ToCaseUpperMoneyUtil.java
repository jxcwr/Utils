package com.jxc.utils.toCaseUpperMoney;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jxc
 * @version 1.0
 * @description TODO 小写数字转换为大写金额
 * @date 2023年01月23日 16:18
 */
public class ToCaseUpperMoneyUtil {
    public static void main(String[] args) {
        System.out.println(getUpCaseMethod("2501.00"));
    }

    private static String getUpCaseMethod(String param) {
        String str = param;
        String strStart = str.split("\\.")[0];

/*        if (StringUtils.isEmpty(str)) {
            return "";
        }

        if (StringUtils.isEmpty(strStart)) {
            return "";
        }*/
        if ("0".equals(strStart)) {
            return "";
        }
        int startInt = Integer.valueOf(strStart);
        if (startInt > 9999) {
            int w = startInt / 10000;
            if (startInt % 10000 == 0) {
                return getUpMoney(w) + "亿元";
            } else {
                String finalStr = "";
                int ws = startInt % 10000;
                if (ws > 999) {
                    finalStr = getUpMoney(w) + "亿";
                } else {
                    finalStr = getUpMoney(w) + "亿零";
                }
                return finalStr + getUpMoney(ws) + "万元";
            }

        } else {

            return getUpMoney(startInt).toString() + "万元";
        }
    }

    private static String getUpMoney(int startInt) {
        //计算千
        int thuInt = startInt / 1000;
        //计算百
        int hunInt = (startInt - (thuInt * 1000)) / 100;
        //计算十
        int desInt = (startInt - (thuInt * 1000) - (hunInt * 100)) / 10;
        //计算个位
        int sinInt = startInt - (thuInt * 1000) - (hunInt * 100) - (desInt * 10);
        String thuStr = "";
        String hunStr = "";
        String desStr = "";
        String sinStr = "";
        HashMap<Integer, String> mapData = new HashMap<>();
        mapData.put(0, "零");
        mapData.put(1, "壹");
        mapData.put(2, "贰");
        mapData.put(3, "叁");
        mapData.put(4, "肆");
        mapData.put(5, "伍");
        mapData.put(6, "陆");
        mapData.put(7, "柒");
        mapData.put(8, "捌");
        mapData.put(9, "玖");
        for (Map.Entry<Integer, String> integerStringEntry : mapData.entrySet()) {
            if (thuInt == integerStringEntry.getKey()) {
                thuStr = integerStringEntry.getValue();
            }
            if (hunInt == integerStringEntry.getKey()) {
                hunStr = integerStringEntry.getValue();
            }
            if (desInt == integerStringEntry.getKey()) {
                desStr = integerStringEntry.getValue();
            }
            if (sinInt == integerStringEntry.getKey()) {
                sinStr = integerStringEntry.getValue();
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (thuStr.equals("零")) {
            if (hunStr.equals("零")) {
                if (desStr.equals("零")) {
                    if (sinStr.equals("零")) {

                    } else {
                        stringBuffer.append(sinStr);
                    }
                } else {
                    stringBuffer.append(desStr + "拾");
                    if (sinStr.equals("零")) {

                    } else {
                        stringBuffer.append(sinStr);
                    }
                }
            } else {
                stringBuffer.append(hunStr + "佰");
                if (desStr.equals("零")) {
                    if (sinStr.equals("零")) {

                    } else {
                        stringBuffer.append("零");
                        stringBuffer.append(sinStr);
                    }
                } else {
                    stringBuffer.append(desStr + "拾");
                    if (sinStr.equals("零")) {

                    } else {
                        stringBuffer.append(sinStr);
                    }
                }
            }
        } else {
            stringBuffer.append(thuStr + "仟");
            if (hunStr.equals("零")) {
                if (desStr.equals("零")) {
                    if (sinStr.equals("零")) {

                    } else {
                        stringBuffer.append("零");
                        stringBuffer.append(sinStr);
                    }
                } else {
                    stringBuffer.append("零");
                    stringBuffer.append(desStr + "拾");
                    if (sinStr.equals("零")) {

                    } else {
                        stringBuffer.append(sinStr);
                    }
                }
            } else {
                stringBuffer.append(hunStr + "佰");
                if (desStr.equals("零")) {
                    if (sinStr.equals("零")) {

                    } else {
                        stringBuffer.append("零");
                        stringBuffer.append(sinStr);
                    }
                } else {
                    stringBuffer.append(desStr + "拾");
                    if (sinStr.equals("零")) {

                    } else {
                        stringBuffer.append(sinStr);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
