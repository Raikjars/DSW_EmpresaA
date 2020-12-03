package daos;

import javax.persistence.EntityManager;
import entidades.Categoria;

public class DaoCategoria extends Dao<Categoria>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoCategoria( )
    {
        super( _handler );
    }

}
