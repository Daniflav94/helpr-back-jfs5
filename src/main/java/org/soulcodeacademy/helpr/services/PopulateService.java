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
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de Setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico geral", "Resolve os chamados urgentes", 12000.0);

        // Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo
        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "68258098144", encoder.encode("12345"), null, c1);
        f1.setPerfil(Perfil.ADMIN);
        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com", "51127383671", encoder.encode("12345"), null, c2);
        Funcionario f3 = new Funcionario (null, "Anitta Zaz", "Anitta.zaz@gmail.com", "44968914687", encoder.encode("12345"), null, c3);
        Funcionario f4 = new Funcionario (null,"Jenifer Lopes","Jenifer.lpz@gmail.com","68237198778", encoder.encode("12345"), null, c1);
        f4.setPerfil(Perfil.ADMIN);
        Funcionario f5 = new Funcionario (null, "Harry Styles", "Harry.stls@gmail.com", "86470827101", encoder.encode("12345"),null,c2 );
        f5.setPerfil(Perfil.ADMIN);
        Funcionario f6 = new Funcionario(null, "Alceu Valença", "Alceu.vlc@gmail.com","24365648683", encoder.encode("12345"),null,c3 );
        f6.setPerfil(Perfil.ADMIN);
        Funcionario f7 = new Funcionario(null, "Lazaro Ramos", "Lazaro.rms@gmail.com","91733168494", encoder.encode("12345"),null, c1 );
        f7.setPerfil(Perfil.ADMIN);


        // Integer id, String nome, String email, String cpf, String senha, String telefone

        Cliente cl1 = new Cliente(null, "José Almir", "jose.almir@gmail.com", "12659185115", encoder.encode("batata"), "011963322145");
        Cliente cl2 = new Cliente(null, "Pedro João", "pedro@gmail.com", "37734168302", encoder.encode("batata"), "011941414141");
        Cliente cl3 = new Cliente(null,"Emma Stone","Ema@gmail.com","95255461105", encoder.encode("batata"), "011963636363");
        Cliente cl4 = new Cliente(null,"Camila de Lucas", "Camila@gmail.com", "21620573954", encoder.encode("batata"),"011987878787" );
        Cliente cl5 = new Cliente(null, "Erika Hilton", "Erika@gmail.com", "87220874359", encoder.encode("batata"),"011963366556" );

        FuturoCandidato fc1 = new FuturoCandidato(null, "Diego", "diego@gmail.com", "candidato para vaga de Manutenção", Setor.MANUTENCAO);
        FuturoCandidato fc2 = new FuturoCandidato(null, "Rafael", "rafael@gmail.com", "candidato para vaga de RH", Setor.RECURSOS_HUMANOS);
        FuturoCandidato fc3 = new FuturoCandidato(null, "Julia", "julia@gmail.com", "candidato para vaga de Marketing", Setor.MARKETING);

        Chamado ch1 = new Chamado(null, "Primeiro chamado do sistema", "Revisar as entidades criadas");
        ch1.setCliente(cl1);

        Chamado ch2 = new Chamado(null, "Ativar VPN do sistema", "Conectar aos servidores remotos");
        ch2.setCliente(cl2);
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);

        Chamado ch3 = new Chamado(null,"Desbloqueio de usuário","Senha bloqueada por excesso de tentativas" );
        ch3.setCliente(cl5);
        ch3.setFuncionario(f7);
        ch3.setStatus(StatusChamado.RECEBIDO);

        Chamado ch4 = new Chamado(null,"Sistema operacional", "Instalação do sistema operacional Windows" );
        ch4.setCliente(cl5);
        ch4.setFuncionario(f6);
        ch4.setStatus(StatusChamado.RECEBIDO);

        Chamado ch5 = new Chamado(null,"Sistema operacional", "Instalação do sistema operacional Linux" );
        ch5.setCliente(cl3);
        ch5.setFuncionario(f5);
        ch5.setStatus(StatusChamado.RECEBIDO);

        Chamado ch6 = new Chamado(null,"Antivírus off", "Cadastrar chave de segurança no antivírus da máquina" );
        ch6.setCliente(cl4);
        ch6.setFuncionario(f3);
        ch6.setStatus(StatusChamado.CONCLUIDO);

        Chamado ch7 = new Chamado(null,"Monitor Queimado", "Liberar um novo monitor para funcionário");
        ch7.setCliente(cl4);

        Chamado ch8 = new Chamado(null,"Limpeza de disco", "Funcionamento da máquina está lento" );
        ch8.setCliente(cl5);
        ch8.setFuncionario(f7);
        ch8.setStatus(StatusChamado.CONCLUIDO);

        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.saveAll(List.of(c1, c2, c3));
        this.funcionarioRepository.saveAll(List.of(f1, f2, f3, f4, f5, f6, f7));
        this.clienteRepository.saveAll(List.of(cl1, cl2, cl2, cl3, cl4, cl5));
        this.chamadoRepository.saveAll(List.of(ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8));
        this.futuroCandidatoRepository.saveAll(List.of(fc1, fc2, fc3));

    }
}

// O objetivo desta classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe