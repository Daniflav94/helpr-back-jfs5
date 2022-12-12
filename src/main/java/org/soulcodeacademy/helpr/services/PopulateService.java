package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.*;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
//import org.soulcodeacademy.helpr.repositories.*;
import org.soulcodeacademy.helpr.repositories.*;
//import org.soulcodeacademy.helpr.security.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// Torna o objeto de PopulateService disponível para toda a aplicação (global)
@Service // indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;


    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void populate() {
        // Integer idCargo, String nome, String descricao, Double salario
        Cargo c1 = new Cargo(null, "Head", "Gerencia toda a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Product Owner", "Coordena o setor de produtos", 18000.0);
        Cargo c3 = new Cargo(null, "Sênior Analyst", "Resolve os chamados urgentes", 12000.0);
        Cargo c4 = new Cargo(null,"Head of Marketing","Gerencia  estratégias de marketing",30000.0);
        Cargo c5 = new Cargo(null, "Head of Product ","Gerencia toda a área de Produtos",30000.0);
        Cargo c6 = new Cargo(null,"Head of D&I","Elabora políticas da empresa que reforçam a diversidade no local de trabalho", 30000.0);


        // Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo
        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "68258098144", encoder.encode("12345"), null, c5);
        f1.setPerfil(Perfil.ADMIN);
        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com", "51127383671", encoder.encode("12345"), null, c2);
        Funcionario f3 = new Funcionario (null, "Anitta Zaz", "Anitta.zaz@gmail.com", "44968914687", encoder.encode("12345"), null, c4);
        Funcionario f4 = new Funcionario (null,"Jenifer Guzman","Jenifer.gzm@gmail.com","68237198778", encoder.encode("12345"), null, c6);
        f4.setPerfil(Perfil.ADMIN);
        Funcionario f5 = new Funcionario (null, "Harry Lemes", "Harry.lm@gmail.com", "86470827101", encoder.encode("12345"),null,c3 );
        f5.setPerfil(Perfil.ADMIN);
        Funcionario f6 = new Funcionario(null, "Alceu Silva", "Alceu.vlc@gmail.com","24365648683", encoder.encode("12345"),null,c3 );
        f6.setPerfil(Perfil.ADMIN);
        Funcionario f7 = new Funcionario(null, "Lazaro Petković", "Lazaro.ptk@gmail.com","91733168494", encoder.encode("12345"),null, c1 );
        f7.setPerfil(Perfil.ADMIN);


        // Integer id, String nome, String email, String cpf, String senha, String telefone

        Cliente cl1 = new Cliente(null, "José Almir", "jose.almir@gmail.com", "12659185115", encoder.encode("batata"), "011963322145");
        Cliente cl2 = new Cliente(null, "Pedro João", "pedro.joão@gmail.com", "37734168302", encoder.encode("batata"), "011941414141");
        Cliente cl3 = new Cliente(null,"Emma Stone","emma.stone@gmail.com","95255461105", encoder.encode("batata"), "011963636363");
        Cliente cl4 = new Cliente(null,"Camila de Lucas", "camila.lucas@gmail.com", "21620573954", encoder.encode("batata"),"011987878787" );
        Cliente cl5 = new Cliente(null, "Erika Hilton", "erika.hilton@gmail.com", "87220874359", encoder.encode("batata"),"011963366556" );

        FuturoCandidato fc1 = new FuturoCandidato(null, "Diego", "diego@gmail.com", "candidato para vaga de Manutenção", Setor.MANUTENCAO);
        FuturoCandidato fc2 = new FuturoCandidato(null, "Rafael", "rafael@gmail.com", "candidato para vaga de RH", Setor.RECURSOS_HUMANOS);
        FuturoCandidato fc3 = new FuturoCandidato(null, "Julia", "julia@gmail.com", "candidato para vaga de Marketing", Setor.MARKETING);

        Chamado ch1 = new Chamado(null, "Primeiro chamado do sistema", "Revisar as entidades criadas");
        ch1.setCliente(cl1);

        Chamado ch2 = new Chamado(null, "Ativar VPN do sistema", "Permitir que todas as máquinas se conectem aos servidores remotos");
        ch2.setCliente(cl2);
        ch2.setFuncionario(f6);
        ch2.setStatus(StatusChamado.ATRIBUIDO);

        Chamado ch3 = new Chamado(null,"Desbloqueio de usuários","Desbloquear todas as senhas bloqueadas por excesso de tentativas" );
        ch3.setCliente(cl5);
        ch3.setStatus(StatusChamado.RECEBIDO);

        Chamado ch4 = new Chamado(null,"Compra de Macbooks Pro 13", "Orçamento e previsão para compra de Macbook Pro 13 para todo setor de marketing" );
        ch4.setCliente(cl5);
        ch4.setStatus(StatusChamado.RECEBIDO);

        Chamado ch5 = new Chamado(null,"Instalação de Linux", "Instalação do sistema operacional Linux em 50% das máquinas" );
        ch5.setCliente(cl3);
        ch5.setStatus(StatusChamado.RECEBIDO);

        Chamado ch6 = new Chamado(null,"Campanha December 12%", "Enviar email com cupon de 12% de desconto para todos clientes da base" );
        ch6.setCliente(cl4);
        ch6.setFuncionario(f3);
        ch6.setStatus(StatusChamado.CONCLUIDO);

        Chamado ch7 = new Chamado(null,"Monitor Queimado", "Liberar um novo monitor para funcionário");
        ch7.setCliente(cl4);

        Chamado ch8 = new Chamado(null,"Contratação", "Contratar novos funcionarios para vagas afirmativas" );
        ch8.setCliente(cl5);
        ch8.setFuncionario(f4);
        ch8.setStatus(StatusChamado.CONCLUIDO);

        Chamado ch9 = new Chamado(null,"Compra de novos monitores", "Orçamento e previsão de compra de novos monitores pra toda empresa" );
        ch9.setCliente(cl3);
        ch9.setFuncionario(f7);
        ch9.setStatus(StatusChamado.ARQUIVADO);



        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.saveAll(List.of(c1, c2, c3, c4, c5, c6));
        this.funcionarioRepository.saveAll(List.of(f1, f2, f3, f4, f5, f6, f7));
        this.clienteRepository.saveAll(List.of(cl1, cl2, cl2, cl3, cl4, cl5));
        this.chamadoRepository.saveAll(List.of(ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9));
        this.futuroCandidatoRepository.saveAll(List.of(fc1, fc2, fc3));

    }
}

// O objetivo desta classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe