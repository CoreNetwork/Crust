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
import us.core_network.crust.io.dsl.tables.records.ClaimRecord;


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
public class TClaim extends TableImpl<ClaimRecord> {

	private static final long serialVersionUID = -1501304561;

	/**
	 * The reference instance of <code>claim</code>
	 */
	public static final TClaim CLAIM = new TClaim();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ClaimRecord> getRecordType() {
		return ClaimRecord.class;
	}

	/**
	 * The column <code>claim.id</code>.
	 */
	public final TableField<ClaimRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>claim.owner</code>.
	 */
	public final TableField<ClaimRecord, String> OWNER = createField("owner", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>claim.minX</code>.
	 */
	public final TableField<ClaimRecord, Integer> MINX = createField("minX", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>claim.maxX</code>.
	 */
	public final TableField<ClaimRecord, Integer> MAXX = createField("maxX", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>claim.minY</code>.
	 */
	public final TableField<ClaimRecord, Integer> MINY = createField("minY", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>claim.maxY</code>.
	 */
	public final TableField<ClaimRecord, Integer> MAXY = createField("maxY", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>claim.minZ</code>.
	 */
	public final TableField<ClaimRecord, Integer> MINZ = createField("minZ", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>claim.maxZ</code>.
	 */
	public final TableField<ClaimRecord, Integer> MAXZ = createField("maxZ", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>claim.parentClaim</code>.
	 */
	public final TableField<ClaimRecord, Integer> PARENTCLAIM = createField("parentClaim", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * Create a <code>claim</code> table reference
	 */
	public TClaim() {
		this("claim", null);
	}

	/**
	 * Create an aliased <code>claim</code> table reference
	 */
	public TClaim(String alias) {
		this(alias, CLAIM);
	}

	private TClaim(String alias, Table<ClaimRecord> aliased) {
		this(alias, aliased, null);
	}

	private TClaim(String alias, Table<ClaimRecord> aliased, Field<?>[] parameters) {
		super(alias, DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ClaimRecord> getPrimaryKey() {
		return Keys.PK_CLAIM;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ClaimRecord>> getKeys() {
		return Arrays.<UniqueKey<ClaimRecord>>asList(Keys.PK_CLAIM);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TClaim as(String alias) {
		return new TClaim(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TClaim rename(String name) {
		return new TClaim(name, null);
	}
}