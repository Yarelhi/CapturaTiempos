package Dao;

import Model.ItgUsersAll;


public interface UsuarioDaoSession {
   public  ItgUsersAll obtenerDatosPorUsuario(ItgUsersAll usuario);
   public ItgUsersAll loginSession(ItgUsersAll usuario);
}
