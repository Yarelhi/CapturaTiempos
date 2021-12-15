package Imp;

import Model.ItgUsersAll;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.Session;


import Util.HibernateUtil;
import Dao.UsuarioDaoSession;


public class UsuarioDaoImpSession implements UsuarioDaoSession{

    @Override
    public ItgUsersAll obtenerDatosPorUsuario(ItgUsersAll usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
    
     String hql = "From ItgUsersAll WHERE username = :username AND Status = 1";
    
     Query q = session.createQuery(hql);
     q.setParameter("username",usuario.getUsername());
     
    

    return (ItgUsersAll)q.uniqueResult();
    }
    

    @Override
    public ItgUsersAll loginSession(ItgUsersAll usuario) {
        ItgUsersAll user = this.obtenerDatosPorUsuario(usuario);
        if (user != null) {
            if (!user.getPassword().equals(DigestUtils.sha512Hex(usuario.getPassword())))
            {
             
              
                user=null;
            }
        }
        return user;
    }
    
}

