package br.edu.ifpi.empregadoIvanp.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class EmpregadoController {

    @GetMapping("/")
    fun abrirMenu(): String{
        return "menu"
    }

    @GetMapping("/reajuste")
    fun abrirTelaReajuste(): String{
        return "reajuste"
    }

    @GetMapping("/calcula/reajuste")
    fun calcularReajuste(
        model: Model,
        nome: String,
        salario: Double): String{

        var salarioReajustado: Double

        if (salario <= 1200){
            salarioReajustado = salario * 1.5
        }else if(salario > 1200 && salario < 3200){
            salarioReajustado = salario * 1.2
        }else{
            salarioReajustado = salario * 1.15
        }

        model.addAttribute("novoSalario", salarioReajustado)
        model.addAttribute("nomeEmpregado", nome)

        return "resultado"

    }



}