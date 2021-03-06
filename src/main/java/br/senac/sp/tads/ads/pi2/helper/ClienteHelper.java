/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.tads.ads.pi2.helper;

import br.senac.sp.tads.ads.pi2.modal.Cliente;
import br.senac.sp.tads.ads.pi2.utils.Conversores;
import br.senac.tads.ads.pi2.view.telaCliente;
import javax.swing.JOptionPane;

/**
 *
 * @author victorsantos
 */
public class ClienteHelper {
    
    private final telaCliente view;
    
    public ClienteHelper(telaCliente view){
        this.view = view;
    }
    
    /** @author victor.santos
     * Metodo que é utilizado para capturar os dados da view para um objeto
     * @return Cliente
     */       
    public Cliente obterModelo(){
        int codigo = 0;
        String codCliente = view.getTxtCodCliente().getText();
        String nome = view.getTxtNomeCliente().getText();
        String sexo;
        if(view.getRdFeminino().isSelected()){
            sexo = "Feminino";
        } else if(view.getRdMasculino().isSelected()){
            sexo = "Masculno";
        } else{
            sexo = "Outro";
        }        
        String email = view.getTxtEmail().getText();
        String cpf = view.getTxtCPF().getText().replaceAll("\\.","").replaceAll("-","");
        String dataNascimento = Conversores.convertDate(view.getTxtDtNascimento().getText());
        String telefone = view.getTxtTelefone().getText();
        String cep = view.getTxtCEP().getText();
        String logadouro = view.getTxtLogadouro().getText();
        String bairro = view.getTxtBairro().getText();
        String cidade = view.getTxtCidade().getText();
        String uf = view.getTxtUF().getText();
        String complemento = view.getTxtComplemento().getText();
        String numero = view.getTxtNum().getText();
        
        if(codCliente.length() >0){
            codigo = Integer.parseInt(codCliente);
        }
        
        Cliente modelo = new Cliente();
        modelo.setNome(nome);
        modelo.setSexo(sexo);
        modelo.setEmail(email);
        modelo.setCpf(cpf);
        modelo.setDataNascimento(dataNascimento);
        modelo.setTelefone(telefone);
        modelo.setCep(cep);
        modelo.setLogadoutro(logadouro);
        modelo.setBairro(bairro);
        modelo.setCidade(cidade);
        modelo.setUf(uf);
        modelo.setId(codigo);
        modelo.setNumero(numero);
        
        if (!"".equals(complemento)){
            modelo.setComplemento(complemento);
        }
        
        
        return modelo;
    }
    
    /** @author victor.santos
     * Metodo que é utilizado para definir os dados da de um objeti na view
     */  
    public void setarModelo(Cliente modelo){
        String codigo = Integer.toString(modelo.getId());
        String nome = modelo.getNome();
        String sexo = modelo.getSexo();
        String email = modelo.getEmail();
        String cpf = modelo.getCpf();
        String nascimento = Conversores.convertDateToView(modelo.getDataNascimento());
        String telefone = modelo.getTelefone();
        String cep = modelo.getCep();
        String logadouro = modelo.getLogadoutro();
        String bairro = modelo.getBairro();
        String cidade = modelo.getCidade();
        String uf = modelo.getUf();
        String complemento = modelo.getComplemento();
        String numero = modelo.getNumero();
        
        view.getTxtCodCliente().setText(codigo);
        view.getTxtNomeCliente().setText(nome);
        if("Feminino".equals(sexo)){
            view.getRdFeminino().setSelected(true);
            view.getRdMasculino().setSelected(false);
            view.getRdOutros().setSelected(false);
        } else if("Masculino".equals(sexo)){
            view.getRdFeminino().setSelected(false);
            view.getRdMasculino().setSelected(true);
            view.getRdOutros().setSelected(false);
        } else{
            view.getRdFeminino().setSelected(false);
            view.getRdMasculino().setSelected(false);
            view.getRdOutros().setSelected(true);
        }
        view.getTxtEmail().setText(email);
        view.getTxtCPF().setText(cpf);
        view.getTxtDtNascimento().setText(nascimento);
        view.getTxtTelefone().setText(telefone);
        view.getTxtCEP().setText(cep);
        view.getTxtLogadouro().setText(logadouro);
        view.getTxtBairro().setText(bairro);
        view.getTxtCidade().setText(cidade);
        view.getTxtUF().setText(uf);
        view.getTxtNum().setText(numero);
        if (!"".equals(complemento)){
            view.getTxtComplemento().setText(complemento);
        }
    }
    
    /** @author victor.santos
     * Metodo que é utilizado para limpar os campos da view
     */  
    public void limparTela(){
        view.getTxtCodCliente().setText("");
        view.getTxtNomeCliente().setText("");
        view.getRdFeminino().setSelected(false);
        view.getRdMasculino().setSelected(false);
        view.getRdOutros().setSelected(false);
        view.getTxtEmail().setText("");
        view.getTxtCPF().setText("");
        view.getTxtDtNascimento().setText("");
        view.getTxtTelefone().setText("");
        view.getTxtCEP().setText("");
        view.getTxtLogadouro().setText("");
        view.getTxtBairro().setText("");
        view.getTxtCidade().setText("");
        view.getTxtUF().setText("");
        view.getTxtComplemento().setText("");
        view.getTxtNum().setText("");
    }
        
}
