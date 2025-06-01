package Class03;

public class Code04_RingArray {
    public static class MyQueue{
        private int[] arr;
        private  int pushi;//end,用户从end加
        private int polli;//begin，用户从begin拿
        private int size;//size管理加与给
        private final int limit;


        public MyQueue(int limit) {
            arr=new int[limit];
            pushi=0;
            polli=0;
            size=0;
            this.limit = limit;
        }

        public void push(int value){
            if(size==limit){
                throw new RuntimeException("队列满了，不能再加了!");
            }
            size++;
            arr[pushi]=value;
            pushi= nextIndex(pushi);
        }
        public int pop(){
            if(size==0){
                throw new RuntimeException("队列空了，不能再拿了!");
            }
            size--;
            int ans=arr[polli];
            polli=nextIndex(polli);
            return ans;
        }
        public boolean isEmpty(){
            return size==0;
        }
        //如果现在的下标是i，返回下一个位置
        private int nextIndex(int i){
            return i<limit-1?i+1:0;
        }
    }
}
