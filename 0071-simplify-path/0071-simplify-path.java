class Solution {
    public String simplifyPath(String path) {

        Stack<String>stack = new Stack<>();
        String[] temp = path.split("/");
        for(int i=0; i<temp.length;i++){
            if(temp[i].equals(".") || temp[i] =="") continue;
            if(temp[i].equals("..") ){
                if(!stack.isEmpty()) stack.pop();

            }else stack.push(temp[i]);

        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0, "/" +stack.pop());
        return sb.length() ==0 ? "/" :sb.toString();

        
    }
}