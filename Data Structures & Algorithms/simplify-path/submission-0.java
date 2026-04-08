class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String i : arr){
            if(i.equals("..") && !stack.isEmpty()){
                stack.pop();
            } else if (!i.isEmpty() && !i.equals(".") && !i.equals("..")) {
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String i : stack){
            sb.append("/");
            sb.append(i);
        }


        return sb.isEmpty() ? "/" : sb.toString();
    }
}