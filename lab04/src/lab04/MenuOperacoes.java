package lab04;

public enum MenuOperacoes {
    CADASTRAR ("1"), 
    LISTAR ("2"), 
    EXCLUIR ("3"), 
    GERAR ("4"), 
    TRANSFERIR ("5"), 
    CALCULAR  ("6"),
    SAIR ("0");

    private final String opcao;

    //construtor
    MenuOperacoes(String opcao) {
        this.opcao = opcao;
    }

    //getter
    public String getMenuOperacoes() {
        return opcao;
    }

    public enum MenuCadastrar {
        CLIENTEPF ("1.1"), 
        CLIENTEPJ ("1.2"), 
        VEICULO ("1.3"),
        SEGURADORA ("1.4"), 
        VOLTAR ("0");

        private final String opcaoCadastro;

        //construtor
        MenuCadastrar(String opcaoCadastro) {
            this.opcaoCadastro = opcaoCadastro;
        }

        //getter
        public String getMenuCadastrar() {
            return opcaoCadastro;
        }
    }

    public enum MenuListar {
        CLIENTES ("2.1"), 
        SINISTROS ("2.2"), 
        SINISTRO_CLIENTE ("2.3"), 
        VEICULO_CLIENTE ("2.4"),
        VEICULO_SEGURADORA ("2.5"),
        VOLTAR ("0");

        private final String opcaoLista;

        //construtor
        MenuListar(String opcaoLista) {
            this.opcaoLista = opcaoLista;
        }

        //getter
        public String getMenuListar() {
            return opcaoLista;
        }
    }


    public enum MenuExcluir {
        CLIENTE ("3.1"), 
        VEICULO ("3.2"), 
        SINISTRO ("3.3"), 
        VOLTAR ("0");

        private final String opcaoExcluir;

        //construtor
        MenuExcluir(String opcaoExcluir) {
            this.opcaoExcluir = opcaoExcluir;
        }

        //getter
        public String getMenuExcluir() {
            return opcaoExcluir;
        }
    }
}

