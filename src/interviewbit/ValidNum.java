package interviewbit;

public class ValidNum {

    public int isNumber(final String A) {
        String s = A.trim();
        return isNumber(s, 0, s.length()-1, false);
    }

    public int isNumber(final String A, int start, int end, boolean hasE) {
        if(start>end){
            return 0;
        }

        if(A.charAt(start) == '-'){
            return isNumber(A, start+1, end, false);
        }

        for(int i=start; i<=end; i++){
            if(A.charAt(i) == 'e'){
                return (isNumber(A, start, i-1, false) ==1 && isNumber(A, i+1, end, true) ==1)?1:0;
            }

            if(A.charAt(i)>='0' && A.charAt(i)<='9'){
                continue;
            }else if(A.charAt(i)=='.'){
                if(i==end || hasE){
                    return 0;
                }
            }else{
                return 0;
            }
        }

        return 1;
    }
    public static void main(String[] args) {
        System.out.println(new ValidNum().isNumber("0.001e10"));
        System.out.println(new ValidNum().isNumber("0.001e-10"));
        System.out.println(new ValidNum().isNumber("-0.001e-10"));

        System.out.println(new ValidNum().isNumber("-0.2"));

        System.out.println(new ValidNum().isNumber("0"));
        System.out.println(new ValidNum().isNumber("001"));
        System.out.println(new ValidNum().isNumber("0.001"));
        System.out.println(new ValidNum().isNumber("3e0.1"));
        System.out.println(new ValidNum().isNumber("3e0."));
        System.out.println(new ValidNum().isNumber("3decde434"));
        System.out.println(new ValidNum().isNumber("++±-3.2.1"));

    }
}
