package interviewbit;

public class ReverseTheString {

    public String solve(String A) {

        A = A.replaceAll("\\s+", " ").trim();

        String[] words = A.split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (int i=words.length -1; i>=0; i--){
            stringBuilder.append(words[i]);
            if(i != 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseTheString r = new ReverseTheString();

        System.out.println(r.solve(" the  fog                 is lifting  "));
    }
}

