/**
 * This class is generated by jOOQ
 */
package us.core_network.crust.io.dsl;


import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import us.core_network.crust.io.dsl.tables.TClaim;
import us.core_network.crust.io.dsl.tables.TPlayer;
import us.core_network.crust.io.dsl.tables.records.ClaimRecord;
import us.core_network.crust.io.dsl.tables.records.PlayerRecord;


/**
 * A class modelling foreign key relationships between tables of the <code></code> 
 * schema
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<ClaimRecord> PK_CLAIM = UniqueKeys0.PK_CLAIM;
	public static final UniqueKey<PlayerRecord> PK_PLAYER = UniqueKeys0.PK_PLAYER;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class UniqueKeys0 extends AbstractKeys {
		public static final UniqueKey<ClaimRecord> PK_CLAIM = createUniqueKey(TClaim.CLAIM, TClaim.CLAIM.ID);
		public static final UniqueKey<PlayerRecord> PK_PLAYER = createUniqueKey(TPlayer.PLAYER, TPlayer.PLAYER.ID);
	}
}