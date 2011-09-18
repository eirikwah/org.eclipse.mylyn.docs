/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.mylyn.docs.epub.ncx;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nav Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getAudio <em>Audio</em>}</li>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getImg <em>Img</em>}</li>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getDir <em>Dir</em>}</li>
 *   <li>{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getLang <em>Lang</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.mylyn.docs.epub.ncx.NCXPackage#getNavLabel()
 * @model
 * @generated
 */
public interface NavLabel extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' containment reference.
	 * @see #setText(Text)
	 * @see org.eclipse.mylyn.docs.epub.ncx.NCXPackage#getNavLabel_Text()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='text' namespace='##targetNamespace'"
	 * @generated
	 */
	Text getText();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getText <em>Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' containment reference.
	 * @see #getText()
	 * @generated
	 */
	void setText(Text value);

	/**
	 * Returns the value of the '<em><b>Audio</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Audio</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Audio</em>' containment reference.
	 * @see #setAudio(Audio)
	 * @see org.eclipse.mylyn.docs.epub.ncx.NCXPackage#getNavLabel_Audio()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='audio' namespace='##targetNamespace'"
	 * @generated
	 */
	Audio getAudio();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getAudio <em>Audio</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Audio</em>' containment reference.
	 * @see #getAudio()
	 * @generated
	 */
	void setAudio(Audio value);

	/**
	 * Returns the value of the '<em><b>Img</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Img</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Img</em>' containment reference.
	 * @see #setImg(Img)
	 * @see org.eclipse.mylyn.docs.epub.ncx.NCXPackage#getNavLabel_Img()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='img' namespace='##targetNamespace'"
	 * @generated
	 */
	Img getImg();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getImg <em>Img</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Img</em>' containment reference.
	 * @see #getImg()
	 * @generated
	 */
	void setImg(Img value);

	/**
	 * Returns the value of the '<em><b>Dir</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.mylyn.docs.epub.ncx.DirType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dir</em>' attribute.
	 * @see org.eclipse.mylyn.docs.epub.ncx.DirType
	 * @see #isSetDir()
	 * @see #unsetDir()
	 * @see #setDir(DirType)
	 * @see org.eclipse.mylyn.docs.epub.ncx.NCXPackage#getNavLabel_Dir()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='dir'"
	 * @generated
	 */
	DirType getDir();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getDir <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dir</em>' attribute.
	 * @see org.eclipse.mylyn.docs.epub.ncx.DirType
	 * @see #isSetDir()
	 * @see #unsetDir()
	 * @see #getDir()
	 * @generated
	 */
	void setDir(DirType value);

	/**
	 * Unsets the value of the '{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getDir <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDir()
	 * @see #getDir()
	 * @see #setDir(DirType)
	 * @generated
	 */
	void unsetDir();

	/**
	 * Returns whether the value of the '{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getDir <em>Dir</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dir</em>' attribute is set.
	 * @see #unsetDir()
	 * @see #getDir()
	 * @see #setDir(DirType)
	 * @generated
	 */
	boolean isSetDir();

	/**
	 * Returns the value of the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lang</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lang</em>' attribute.
	 * @see #setLang(String)
	 * @see org.eclipse.mylyn.docs.epub.ncx.NCXPackage#getNavLabel_Lang()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NMTOKEN"
	 *        extendedMetaData="kind='attribute' name='lang' namespace='http://www.w3.org/XML/1998/namespace'"
	 * @generated
	 */
	String getLang();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.epub.ncx.NavLabel#getLang <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lang</em>' attribute.
	 * @see #getLang()
	 * @generated
	 */
	void setLang(String value);

} // NavLabel
