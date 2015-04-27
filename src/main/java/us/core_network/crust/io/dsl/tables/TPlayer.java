/**
 * This class is generated by jOOQ
 */
package us.core_network.crust.io.dsl.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import us.core_network.crust.io.dsl.DefaultSchema;
import us.core_network.crust.io.dsl.Keys;
import us.core_network.crust.io.dsl.tables.records.PlayerRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TPlayer extends TableImpl<PlayerRecord> {

	private static final long serialVersionUID = 1889033404;

	/**
	 * The reference instance of <code>player</code>
	 */
	public static final TPlayer PLAYER = new TPlayer();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<PlayerRecord> getRecordType() {
		return PlayerRecord.class;
	}

	/**
	 * The column <code>player.id</code>.
	 */
	public final TableField<PlayerRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>player.claimBlocks</code>.
	 */
	public final TableField<PlayerRecord, Integer> CLAIMBLOCKS = createField("claimBlocks", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>player.lastName</code>.
	 */
	public final TableField<PlayerRecord, String> LASTNAME = createField("lastName", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * Create a <code>player</code> table reference
	 */
	public TPlayer() {
		this("player", null);
	}

	/**
	 * Create an aliased <code>player</code> table reference
	 */
	public TPlayer(String alias) {
		this(alias, PLAYER);
	}

	private TPlayer(String alias, Table<PlayerRecord> aliased) {
		this(alias, aliased, null);
	}

	private TPlayer(String alias, Table<PlayerRecord> aliased, Field<?>[] parameters) {
		super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<PlayerRecord> getPrimaryKey() {
		return Keys.PK_PLAYER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<PlayerRecord>> getKeys() {
		return Arrays.<UniqueKey<PlayerRecord>>asList(Keys.PK_PLAYER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TPlayer as(String alias) {
		return new TPlayer(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TPlayer rename(String name) {
		return new TPlayer(name, null);
	}
}