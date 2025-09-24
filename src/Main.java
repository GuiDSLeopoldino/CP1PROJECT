import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        int proximoId = 1;
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n===== ToDoLIST =====");
            System.out.println("1) Adicionar tarefa");
            System.out.println("2) Listar tarefas");
            System.out.println("3) Marcar tarefa como concluída");
            System.out.println("4) Desmarcar tarefa");
            System.out.println("5) Remover tarefa");
            System.out.println("6) Sair");
            System.out.print("Escolha uma opção: ");
            String op = sc.nextLine();

            if (op.equals("1")) {
                System.out.print("Digite o título da tarefa: ");
                String titulo = sc.nextLine();

                if (titulo.equals("")) {
                    System.out.println("Título não pode ser vazio!");
                } else {
                    Tarefa t = new Tarefa(proximoId, titulo);
                    tarefas.add(t);
                    System.out.println("Tarefa adicionada com id " + proximoId);
                    proximoId = proximoId + 1;
                }

            } else if (op.equals("2")) {
                if (tarefas.size() == 0) {
                    System.out.println("Nenhuma tarefa cadastrada.");
                } else {
                    for (int i = 0; i < tarefas.size(); i++) {
                        Tarefa t = tarefas.get(i);
                        String status = "[ ]";
                        if (t.concluida == true) {
                            status = "[X]";
                        }
                        System.out.println(status + " " + t.id + " - " + t.titulo);
                    }
                }

            } else if (op.equals("3")) {
                System.out.print("Digite o id da tarefa para concluir: ");
                int id = sc.nextInt();
                sc.nextLine(); // limpar buffer
                boolean achou = false;
                for (int i = 0; i < tarefas.size(); i++) {
                    Tarefa t = tarefas.get(i);
                    if (t.id == id) {
                        t.concluida = true;
                        System.out.println("Tarefa concluída!");
                        achou = true;
                    }
                }
                if (achou == false) {
                    System.out.println("Id não encontrado.");
                }

            } else if (op.equals("4")) {
                System.out.print("Digite o id da tarefa para desmarcar: ");
                int id = sc.nextInt();
                sc.nextLine(); // limpar buffer
                boolean achou = false;
                for (int i = 0; i < tarefas.size(); i++) {
                    Tarefa t = tarefas.get(i);
                    if (t.id == id) {
                        t.concluida = false;
                        System.out.println("Tarefa desmarcada!");
                        achou = true;
                    }
                }
                if (achou == false) {
                    System.out.println("Id não encontrado.");
                }

            } else if (op.equals("5")) {
                System.out.print("Digite o id da tarefa para remover: ");
                int id = sc.nextInt();
                sc.nextLine(); // limpar buffer
                boolean removida = false;
                for (int i = 0; i < tarefas.size(); i++) {
                    Tarefa t = tarefas.get(i);
                    if (t.id == id) {
                        tarefas.remove(i);
                        System.out.println("Tarefa removida!");
                        removida = true;
                        i = tarefas.size(); // força sair do loop
                    }
                }
                if (removida == false) {
                    System.out.println("Id não encontrado.");
                }

            } else if (op.equals("6")) {
                System.out.println("Saindo...");
                rodando = false;

            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
}
