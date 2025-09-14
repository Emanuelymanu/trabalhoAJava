import java.util.LinkedList;
import java.util.Queue;

public class FilaAtendimento {

    private Queue<Paciente> fila;

    public FilaAtendimento(){
        fila = new LinkedList<>();
    }

    public void adicionarPaciente(Paciente p){
        fila.add(p);
    }

    public Paciente atenderPaciente(){
        return fila.poll();
    }

    public boolean estaVazia(){
        return fila.isEmpty();
    }

    public void mostrarFila(){
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia");
            return;
        }

        System.out.println("°°°°°°°Fila de atendiemento°°°°°°°°°°");
        int posicao=1;
        for(Paciente paciente : fila){
            System.out.println(posicao + "-" + paciente.exibirInfo());
            posicao++;
        }
    }
}
