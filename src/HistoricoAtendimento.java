import java.util.Stack;

public class HistoricoAtendimento {
     private Stack<Paciente> historico;

     public HistoricoAtendimento(){
         historico = new Stack<>();
     }

     public void adicionarHistorico(Paciente p){
         historico.push(p);
     }

     public Paciente verUltimoAtendido(){
         return historico.isEmpty()? null : historico.peek();
     }

     public void mostrarHistorico(){
         if(historico.isEmpty()){
             System.out.println("Nenhum paciente atendido");
             return;
         }
         System.out.println("°°°°°°°°°Histórico de atendimentos°°°°°°°°°°°°");
         for(int i = historico.size()-1; i >=0;i--){
             System.out.println(historico.get(i).exibirInfo());
         }
     }
}



