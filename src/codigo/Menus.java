package codigo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menus {
	public void novoPedido(Conexao conn) throws NumberFormatException, SQLException {
		Scanner entrada = new Scanner(System.in);
		//int cod_garcom = 0;
		int cod_mesa = 0;
		int cod_cliente = 0; //TODO realizar conex�o com o banco
		double total = 0;
		ArrayList<Integer> cod_produtos =new ArrayList<Integer>();
		int opcao = 0;
		
	/*	System.out.print("Digite o c�digo do gar�om: ");
		cod_garcom = entrada.nextInt();
	*/	
		System.out.print("Digite o c�digo da mesa(1-20): ");
		cod_mesa = entrada.nextInt();
		
		do {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		if(opcao == 1) {
			double valor = 0;
			System.out.println("C�digo / Nome / Descri��o / Valor");
			conn.mostrar_sql("SELECT itm_codigo, itm_nome, itm_descricao, TRUNCATE(itm_valor, 2) FROM t_itens");
			System.out.println("Digite um c�digo para adicionar: ");
			cod_produtos.add(entrada.nextInt());
			valor += Double.parseDouble(conn.retornar_valor(cod_produtos.get(cod_produtos.size()-1).intValue(), "itm_valor","itm_codigo", "t_itens"));
			total += valor;
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Adicionado o item " + conn.retornar_valor(cod_produtos.get(cod_produtos.size()-1).intValue(), "itm_nome","itm_codigo", "t_itens") + " no valor de R$ "+valor+"0"+"!\n");
		}
		System.out.println("== Novo pedido ==\n");
		System.out.println("  1 - Adicionar item");
		System.out.println("  2 - Fechar pedido");
		System.out.print("> ");
		opcao = entrada.nextInt();
		}while(opcao != 2);
		
		int codigo_pedido = 0;
		conn.comando_sql("INSERT INTO `t_pedidos`" + 
				"(`ped_valor`," + 
				"`mesa_codigo`)" + 
				"VALUES " + 
				"("+total+"," + 
				cod_mesa+");");

		codigo_pedido = Integer.parseInt(conn.retornar_ultima_celula("t_pedidos", "ped_codigo"));
		
		for(int i = 0; i<cod_produtos.size(); i++) {
			conn.comando_sql("INSERT INTO `t_pedido_itens`" + 
					"(`itm_codigo`," + 
					"`ped_codigo`)" + 
					"VALUES\r\n" + 
					"("+cod_produtos.get(i).intValue()+", " +
					""+codigo_pedido+");" + 
					"");
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("== Pedido N� "+codigo_pedido+" fechado! ==");
		System.out.println("  Cliente: "+ "CLIENTE N�O IDENTIFICADO"); // TODO puxar informa��o do banco.
	//	System.out.println("  Gar�om: "+conn.retornar_valor(cod_garcom, "gar_nome","gar_codigo", "garcom"));
		System.out.println("  Mesa: "+cod_mesa);
		
		System.out.println("\nC�digo / Nome / Valor");
		for(int i = 0; i<cod_produtos.size(); i++) {
			conn.mostrar_sql("SELECT itm_codigo, itm_nome, TRUNCATE(itm_valor, 2) FROM t_itens WHERE itm_codigo = "+ cod_produtos.get(i).intValue());
		}
		System.out.println("\nTotal: R$ "+total+"0");
		
		try {
			System.out.println("Pressione qualquer tecla para continuar....");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
