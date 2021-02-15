function submit(){
    document.getElementById("len").innerHTML="Length is: ";
    document.getElementById("str").innerHTML="Displaying....";
    document.getElementById("vc").innerHTML="Separating Vowels and consonants....";
    document.getElementById("err").innerHTML="Checking if theres a number in the input...";

    let b=document.getElementById("text");
    document.getElementById("len").innerHTML+='\n'+b.value.length;
    document.getElementById("str").innerHTML+='\n'+b.value.toUpperCase()+"  "+b.value.toLowerCase();

    function vowelsAndConsonants(s) {
        const vowels = 'aeiou';
        var consonants = [];var v=[];
        for (var i = 0; i < s.length; i++) {
        if (vowels.includes(s[i])) {
        v+=s[i];
        } else {
        consonants += s[i];
        }
        }
        return [v,consonants];
   }

    var arr=vowelsAndConsonants(b.value);
    document.getElementById("vc").innerHTML+='\n'+arr[0].toString()+"   "+arr[1].toString();


    if (b.value.search("[0-9]")!==-1)
    {   
        document.getElementById("err").innerHTML+='\n'+"User-defined Exception:Input should not have a Number!!Check the console";
        throw new Error("User-defined Exception:Input should not have a Number!!");
    }
    else
    {
        document.getElementById("err").innerHTML+='\n'+"No Number in input";
    }
    
}