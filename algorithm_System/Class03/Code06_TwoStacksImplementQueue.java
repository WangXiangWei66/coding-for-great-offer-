package Class03;

import java.util.Stack;

public class Code06_TwoStacksImplementQueue {
    public static class TwoStackQueue{
        public Stack<Integer> stackpush;
        public Stack<Integer> stackpop;

        public TwoStackQueue(){
            stackpush=new Stack<Integer>();
            stackpop=new Stack<Integer>();
        }

        //push栈向pop栈导入数据
        public void pushToPop(){
            if(stackpop.empty()){
                while(!stackpush.empty()){
                    stackpop.push(stackpush.pop());
                }
            }
        }

        public void add(int pushInt){
            stackpush.push(pushInt);
            pushToPop();
        }

        public int poll(){
            if(stackpop.empty()&&stackpush.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackpop.pop();
        }

        public int peek(){
            if(stackpop.empty()&&stackpush.empty()){
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackpop.peek();
        }
    }

    public static void main(String[]args){
        TwoStackQueue test = new TwoStackQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
