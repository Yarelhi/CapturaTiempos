    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package Dao;

    import Model.ItgInvoiceAll;
    import Model.ItgPersonalInfoAll;
    import Model.ItgProjectsAll;
    import java.util.List;
    /**
     *
     * @author Diana
     */
    public interface InvoisedDao {

        public List<ItgInvoiceAll> mostrarFacturas();

        public void nuevaFactura(ItgInvoiceAll itgInvoiceAll);
        //Lista Clientes
        public List<ItgPersonalInfoAll> listarClient();
        //Lista Proyectos
        public List<ItgProjectsAll> listarProy(int cliente);

        public List<ItgInvoiceAll> listarConsultor();

    }
