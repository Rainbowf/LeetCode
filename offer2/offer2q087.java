package offer2;

import java.util.*;

class Solution087 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        helper(s, res, 0, 0, "", "");
        return res;
    }

    private void helper(String s, List<String> res, int i, int segI, String seg, String ip) {
        if (i == s.length() && segI == 3 && isValidSeg(seg)) {
            res.add(ip + seg);
        } else if (i < s.length() && segI <= 3) {
            char ch = s.charAt(i);
            //当前段继续延长
            if (isValidSeg(seg + ch)) {
                helper(s, res, i + 1, segI, seg + ch, ip);
            }
            //当前段不延长
            if (seg.length() > 0 && segI < 3) {
                helper(s, res, i + 1, segI + 1, "" + ch, ip + seg + ".");
            }
        }
    }

    private boolean isValidSeg(String seg) {
        return Integer.valueOf(seg) <= 255
                && (seg.equals("0") || seg.charAt(0) != '0');
    }
}