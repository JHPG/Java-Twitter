var qtd = 255;


function onLoad(){
    contarChar(document.getElementById("txtMensagem").value);
}

function contarChar(value){     //Trava o campo no limite de caracteres
    
    if(value.length <= qtd){
        document.getElementById("contagem").innerHTML =  qtd - value.length;
    }
    else{
        document.getElementById("txtMensagem").value = value.substr(0,qtd);
    }
}

function getEmoticon(tipo){     //Adiciona emoticon na textarea
    var texto="";

    switch(tipo) {
        case "deOlho": texto = ".v."; break;        //aqui
        case "sorriso": texto = ":D"; break;
        case "triste": texto = ":("; break;
        case "img2": texto = "^D"; break;
    }
    var txtMensagem = document.getElementById("txtMensagem");
    txtMensagem.value += texto;
    contarChar(txtMensagem.value);  //Altera contador de caracteres
}

function insereEmoticons(texto){

    var dir = "emoticons/";
    var res = texto;

    //Substitui para exibir
    for(i=0; (i<texto.split(".v.").length);i++){ res = res.replace(".v.", "<img src='"+ dir + "deOlho.gif' alt='' />"); }   //aqui (2x)
    for(i=0; (i<texto.split(":D").length);i++){ res = res.replace(":D", "<img src='"+ dir + "sorriso.gif' alt='' />"); }
    for(i=0; (i<texto.split(":(").length);i++){ res = res.replace(":(", "<img src='"+ dir + "triste.gif' alt='' />"); }
    for(i=0; (i<texto.split("^D").length);i++){ res = res.replace("^D", "<img src='"+ dir + "img2.gif' alt='' />"); }    

    return res;
    alert(res);

    /*   //Teste inicial
    var textoF = "", i=0;

    var emoticons = [".||.", ":)", ":("]; //[3]	//Monta vetores com emoticons (1) e o nome das imagens (2)
    var dir = "emoticons/";
    var imagens = ["deOlho.jpg", "sorriso.jpg", "triste.jpg"]; //[3]

    i = 0;
    for(var em in emoticons){	//Verifica os emoticons
            var res = texto.split(em);	//Divide o texto
        if(emoticons.length <= i){	//para não dar erro
            for(var s in res){	//insere o emoticon e monta o texto
                textoF += res + "<img src='"+ dir + imagens[i] +"' alt='' />";
            }
        }
        i++;
    }
    return textoF;
    */
}

