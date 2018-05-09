/**
 * Created by Asus on 22.03.2017.
 */
public class Main {

        static final int MAX_SIZE = 100;
        static final int WORK_TIME = 120000;
        static MaxHeap Heap = new MaxHeap();
        static Process[] scheduler = new Process[MAX_SIZE];
        static int index = 0;
        static String result = "";

    static void solution() {
        Reader.Init("input.csv");
        Writer out = new Writer("output.txt");
        Reader.readLine();
        while (Reader.sc.hasNext()) {
            String s = Reader.readLine();
            String[] input = s.split(",");
            scheduler[index] = new Process();
            scheduler[index].name = input[0];
            scheduler[index].event = Integer.parseInt(input[1]);
            scheduler[index].time = Integer.parseInt(input[2]);
            scheduler[index].priority = Integer.parseInt(input[3]);
            index++;
        }

        int time = 0, step = 0;
        while (step < index){
            if (Heap.isEmpty()) {
                Heap.add(scheduler[step].priority, step);
                if (time < scheduler[step].event)
                    time = scheduler[step].event;
            }

            int highest = Heap.MaxValue();
            step++;

            while (step < index && scheduler[step].event <= time + scheduler[highest].time){
                Heap.add(scheduler[step].priority, step);
                step++;
            }

            time += scheduler[highest].time;
            if (time <= WORK_TIME)
                result = scheduler[highest].name;

            while ((step >= index - 1 || scheduler[step + 1].event > time) && !Heap.isEmpty()){
                highest = Heap.MaxValue();
                time += scheduler[highest].time;
                if (time <= WORK_TIME)
                    result = scheduler[highest].name;
            }
        }

        out.write(result);
        out.close();

    }

    public static void main(String[] args) {
        solution();
    }
}

