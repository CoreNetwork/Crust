/**
 * This class is generated by jOOQ
 */
package us.core_network.crust.io.dsl.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import us.core_network.crust.io.dsl.tables.TClaim;


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
public class ClaimRecord extends UpdatableRecordImpl<ClaimRecord> implements Record9<Integer, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer> {

	private static final long serialVersionUID = 1550965000;

	/**
	 * Setter for <code>claim.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>claim.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>claim.owner</code>.
	 */
	public void setOwner(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>claim.owner</code>.
	 */
	public String getOwner() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>claim.minX</code>.
	 */
	public void setMinx(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>claim.minX</code>.
	 */
	public Integer getMinx() {
		return (Integer) getValue(2);
	}

	/**
	 * Setter for <code>claim.maxX</code>.
	 */
	public void setMaxx(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>claim.maxX</code>.
	 */
	public Integer getMaxx() {
		return (Integer) getValue(3);
	}

	/**
	 * Setter for <code>claim.minY</code>.
	 */
	public void setMiny(Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>claim.minY</code>.
	 */
	public Integer getMiny() {
		return (Integer) getValue(4);
	}

	/**
	 * Setter for <code>claim.maxY</code>.
	 */
	public void setMaxy(Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>claim.maxY</code>.
	 */
	public Integer getMaxy() {
		return (Integer) getValue(5);
	}

	/**
	 * Setter for <code>claim.minZ</code>.
	 */
	public void setMinz(Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>claim.minZ</code>.
	 */
	public Integer getMinz() {
		return (Integer) getValue(6);
	}

	/**
	 * Setter for <code>claim.maxZ</code>.
	 */
	public void setMaxz(Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>claim.maxZ</code>.
	 */
	public Integer getMaxz() {
		return (Integer) getValue(7);
	}

	/**
	 * Setter for <code>claim.parentClaim</code>.
	 */
	public void setParentclaim(Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>claim.parentClaim</code>.
	 */
	public Integer getParentclaim() {
		return (Integer) getValue(8);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
		return (Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer> valuesRow() {
		return (Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return TClaim.CLAIM.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return TClaim.CLAIM.OWNER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return TClaim.CLAIM.MINX;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return TClaim.CLAIM.MAXX;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field5() {
		return TClaim.CLAIM.MINY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return TClaim.CLAIM.MAXY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field7() {
		return TClaim.CLAIM.MINZ;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field8() {
		return TClaim.CLAIM.MAXZ;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field9() {
		return TClaim.CLAIM.PARENTCLAIM;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getOwner();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getMinx();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getMaxx();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value5() {
		return getMiny();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getMaxy();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value7() {
		return getMinz();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value8() {
		return getMaxz();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value9() {
		return getParentclaim();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value2(String value) {
		setOwner(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value3(Integer value) {
		setMinx(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value4(Integer value) {
		setMaxx(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value5(Integer value) {
		setMiny(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value6(Integer value) {
		setMaxy(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value7(Integer value) {
		setMinz(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value8(Integer value) {
		setMaxz(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord value9(Integer value) {
		setParentclaim(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClaimRecord values(Integer value1, String value2, Integer value3, Integer value4, Integer value5, Integer value6, Integer value7, Integer value8, Integer value9) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ClaimRecord
	 */
	public ClaimRecord() {
		super(TClaim.CLAIM);
	}

	/**
	 * Create a detached, initialised ClaimRecord
	 */
	public ClaimRecord(Integer id, String owner, Integer minx, Integer maxx, Integer miny, Integer maxy, Integer minz, Integer maxz, Integer parentclaim) {
		super(TClaim.CLAIM);

		setValue(0, id);
		setValue(1, owner);
		setValue(2, minx);
		setValue(3, maxx);
		setValue(4, miny);
		setValue(5, maxy);
		setValue(6, minz);
		setValue(7, maxz);
		setValue(8, parentclaim);
	}
}
