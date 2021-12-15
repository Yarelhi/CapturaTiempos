
function PromptDemo() {
    
    a=document.getElementById("id").value;
    
    if(a != 4){
        alert("Acceso Restringido");
        if(a == 1){
            location.href=("/CapturaTiempos/faces/Views/Direccion/Direccionindex.xhtml");
        
    }else if (a == 2){
        location.href=("/CapturaTiempos/faces/Views/Admin/A-AdminIndex.xhtml");
    }else if (a == 3){
        location.href=("/CapturaTiempos/faces/Views/Gerente/G-Index.xhtml");
    }
    }

}


