package com.exemplo.aulamc;

import com.exemplo.aulamc.domain.*;
import com.exemplo.aulamc.domain.enums.EstadoPagamento;
import com.exemplo.aulamc.domain.enums.TipoCliente;
import com.exemplo.aulamc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class AulamcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(AulamcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        /*cat1.setProdutos(Arrays.asList(p1, p2, p3));
        cat2.setProdutos(Arrays.asList(p2));

        p1.setCategorias(Arrays.asList(cat1));
        p2.setCategorias(Arrays.asList(cat1, cat2));
        p3.setCategorias(Arrays.asList(cat1));*/

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().add(p2);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Luiz Felipe", "felipe.sirio@gmail.com", "00471556041", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("999909097", "30594724"));

        Endereco endereco = new Endereco(null, "Rua das Orquídeas", "153", "Casa", "5 Colônias", "92320390", cli1, c1);
        Endereco endereco2 = new Endereco(null, "Rua das Orquídeas", "153", "Casa", "5 Colônias", "92320390", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(endereco, endereco2));

        clienteRepository.saveAll((Arrays.asList(cli1)));
        enderecoRepository.saveAll((Arrays.asList(endereco, endereco2)));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/07/2019 10:20"), cli1, endereco);
        Pedido ped2 = new Pedido(null, sdf.parse("30/07/2019 18:08"), cli1, endereco2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE, ped2, sdf.parse("15/08/2019 00:00"), sdf.parse("30/07/2019 00:00"));
        ped2.setPagamento(pagto2);

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(p1, ped1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(p3, ped1, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(p2, ped2, 100.00, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip3));
        ped2.getItens().addAll(Arrays.asList(ip2));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }
}
