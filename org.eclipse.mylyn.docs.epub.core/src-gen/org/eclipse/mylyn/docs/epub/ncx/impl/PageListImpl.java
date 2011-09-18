/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.mylyn.docs.epub.ncx.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.mylyn.docs.epub.ncx.NCXPackage;
import org.eclipse.mylyn.docs.epub.ncx.NavInfo;
import org.eclipse.mylyn.docs.epub.ncx.NavLabel;
import org.eclipse.mylyn.docs.epub.ncx.PageList;
import org.eclipse.mylyn.docs.epub.ncx.PageTarget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.impl.PageListImpl#getNavInfos <em>Nav Infos</em>}</li>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.impl.PageListImpl#getNavLabels <em>Nav Labels</em>}</li>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.impl.PageListImpl#getPageTargets <em>Page Targets</em>}</li>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.impl.PageListImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.impl.PageListImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageListImpl extends EObjectImpl implements PageList {
	/**
	 * The cached value of the '{@link #getNavInfos() <em>Nav Infos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<NavInfo> navInfos;

	/**
	 * The cached value of the '{@link #getNavLabels() <em>Nav Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<NavLabel> navLabels;

	/**
	 * The cached value of the '{@link #getPageTargets() <em>Page Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<PageTarget> pageTargets;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final Object CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected Object class_ = CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PageListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NCXPackage.Literals.PAGE_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NavInfo> getNavInfos() {
		if (navInfos == null) {
			navInfos = new EObjectContainmentEList<NavInfo>(NavInfo.class, this, NCXPackage.PAGE_LIST__NAV_INFOS);
		}
		return navInfos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NavLabel> getNavLabels() {
		if (navLabels == null) {
			navLabels = new EObjectContainmentEList<NavLabel>(NavLabel.class, this, NCXPackage.PAGE_LIST__NAV_LABELS);
		}
		return navLabels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageTarget> getPageTargets() {
		if (pageTargets == null) {
			pageTargets = new EObjectContainmentEList<PageTarget>(PageTarget.class, this, NCXPackage.PAGE_LIST__PAGE_TARGETS);
		}
		return pageTargets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(Object newClass) {
		Object oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NCXPackage.PAGE_LIST__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NCXPackage.PAGE_LIST__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NCXPackage.PAGE_LIST__NAV_INFOS:
				return ((InternalEList<?>)getNavInfos()).basicRemove(otherEnd, msgs);
			case NCXPackage.PAGE_LIST__NAV_LABELS:
				return ((InternalEList<?>)getNavLabels()).basicRemove(otherEnd, msgs);
			case NCXPackage.PAGE_LIST__PAGE_TARGETS:
				return ((InternalEList<?>)getPageTargets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NCXPackage.PAGE_LIST__NAV_INFOS:
				return getNavInfos();
			case NCXPackage.PAGE_LIST__NAV_LABELS:
				return getNavLabels();
			case NCXPackage.PAGE_LIST__PAGE_TARGETS:
				return getPageTargets();
			case NCXPackage.PAGE_LIST__CLASS:
				return getClass_();
			case NCXPackage.PAGE_LIST__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NCXPackage.PAGE_LIST__NAV_INFOS:
				getNavInfos().clear();
				getNavInfos().addAll((Collection<? extends NavInfo>)newValue);
				return;
			case NCXPackage.PAGE_LIST__NAV_LABELS:
				getNavLabels().clear();
				getNavLabels().addAll((Collection<? extends NavLabel>)newValue);
				return;
			case NCXPackage.PAGE_LIST__PAGE_TARGETS:
				getPageTargets().clear();
				getPageTargets().addAll((Collection<? extends PageTarget>)newValue);
				return;
			case NCXPackage.PAGE_LIST__CLASS:
				setClass(newValue);
				return;
			case NCXPackage.PAGE_LIST__ID:
				setId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NCXPackage.PAGE_LIST__NAV_INFOS:
				getNavInfos().clear();
				return;
			case NCXPackage.PAGE_LIST__NAV_LABELS:
				getNavLabels().clear();
				return;
			case NCXPackage.PAGE_LIST__PAGE_TARGETS:
				getPageTargets().clear();
				return;
			case NCXPackage.PAGE_LIST__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case NCXPackage.PAGE_LIST__ID:
				setId(ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NCXPackage.PAGE_LIST__NAV_INFOS:
				return navInfos != null && !navInfos.isEmpty();
			case NCXPackage.PAGE_LIST__NAV_LABELS:
				return navLabels != null && !navLabels.isEmpty();
			case NCXPackage.PAGE_LIST__PAGE_TARGETS:
				return pageTargets != null && !pageTargets.isEmpty();
			case NCXPackage.PAGE_LIST__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case NCXPackage.PAGE_LIST__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (class: ");
		result.append(class_);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //PageListImpl
